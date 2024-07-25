package com.yupi.yuoj.manager;

import io.github.briqt.spark4j.SparkClient;
import io.github.briqt.spark4j.constant.SparkApiVersion;
import io.github.briqt.spark4j.model.SparkMessage;
import io.github.briqt.spark4j.model.SparkSyncChatResponse;
import io.github.briqt.spark4j.model.request.SparkRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class SparkManager {

    @Resource
    private SparkClient sparkClient;

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
     * 向星火AI发送请求
     *
     * @param content
     * @return
     */
    public String sendMesToAIUseXingHuo(final String content) {
        // 消息列表，可以在此列表添加历史对话记录
        List<SparkMessage> messages = new ArrayList<>();
//        messages.add(SparkMessage.systemContent(PRECONDITION));
        messages.add(SparkMessage.userContent(PRECONDITION + content));
        // 构造请求
        SparkRequest sparkRequest = SparkRequest.builder()
                // 消息列表
                .messages(messages)
                // 模型回答的tokens的最大长度，非必传，默认为2048
                .maxTokens(2048)
                // 结果随机性，取值越高随机性越强，即相同的问题得到的不同答案的可能性越高，非必传，取值为[0,1]，默认为0.5
                .temperature(0.2)
                // 指定请求版本
                .apiVersion(SparkApiVersion.V3_5)
                .build();
        // 同步调用
        SparkSyncChatResponse chatResponse = sparkClient.chatSync(sparkRequest);
        String responseContent = chatResponse.getContent();
        log.info("星火AI返回的结果{}", responseContent);
        return responseContent;
    }
}
