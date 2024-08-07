package com.yupi.yuoj.manager;

import com.yupi.yucongming.dev.client.YuCongMingClient;
import com.yupi.yucongming.dev.common.BaseResponse;
import com.yupi.yucongming.dev.model.DevChatRequest;
import com.yupi.yucongming.dev.model.DevChatResponse;
import com.yupi.yuoj.common.ErrorCode;
import com.yupi.yuoj.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class AIManager {
    @Resource
    private YuCongMingClient yuCongMingClient;

    @Value("${yuapi.client.id}")
    private Long id;

    /**
     * AI生成问题的预设条件
     */
    public static final String PRECONDITION = "你是一个代码分析器，接下来我会按照以下固定格式给你提供内容:\n" +
            "分析需求:\n" +
            "{编译并运行代码，如果有问题则抛出，否则输出正确答案}\n" +
            "原始数据:\n" +
            "{待分析代码，语言，参数}（以上每部分使用 【 隔离）(参数使用列表，内容间使用逗号分割，参数间使用空格隔离，如果没有参数，则不输入)\n" +
            "请根据以上内容,按照以下指定格式生成内容(此外不要输出多余的开头，结尾，注释):\n" +
            "【【【\n" +
            "{如果发生错误，才抛出错误信息，否则只输出代码结果，不要有多于的注解或文字}\n" +
            "【【【\n" +
            "\n" +
            "例子：\n" +
            "输入：\n" +
            "public class Main {\n" +
            "    public static void main(String[] args) {\n" +
            "        try {\n" +
            "            // 将参数转换为整数\n" +
            "            int num1 = Integer.parseInt(args[0]);\n" +
            "            int num2 = Integer.parseInt(args[1]);\n" +
            "            int sum = num1 - num2;\n" +
            "            System.out.println(sum);\n" +
            "        } catch (NumberFormatException e) {\n" +
            "            System.out.println(\"输入的参数不是有效的整数。\");\n" +
            "        }\n" +
            "    }\n" +
            "}【java【10 2,8 8,4 -1,-4 -4\n" +
            "\n" +
            "输出：\n" +
            "【【【\n" +
            "8\n" +
            "0\n" +
            "5\n" +
            "0\n" +
            "【【【\n\n";


    /**
     * AI 对话
     *
     * @param message
     * @return
     */
    public String doChat(String message) {
        // 第三步，构造请求参数
        DevChatRequest devChatRequest = new DevChatRequest();
        // 模型id，尾后加L，转成long类型
        devChatRequest.setModelId(id);
        devChatRequest.setMessage(message);
        // 第四步，获取响应结果
        BaseResponse<DevChatResponse> response = yuCongMingClient.doChat(devChatRequest);
        // 如果响应为null，就抛出系统异常，提示“AI 响应错误”
        if (response == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "AI 响应错误");
        }
        return response.getData().getContent();
    }
}
