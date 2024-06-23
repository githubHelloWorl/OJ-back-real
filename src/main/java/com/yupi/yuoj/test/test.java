package com.yupi.yuoj.test;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.excel.util.StringUtils;
import com.yupi.yuoj.common.ErrorCode;
import com.yupi.yuoj.exception.BusinessException;
import com.yupi.yuoj.judge.codesandbox.model.ExecuteCodeRequest;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;
import java.util.List;

public class test {

    private static final String host = "121.41.56.218";

    // 定义鉴权请求头和密钥
    private static final String AUTH_REQUEST_HEADER = "auth";

    private static final String AUTH_REQUEST_SECRET = "secretKey";

    public static void main(String[] args) {
//
//            UserLoginRequest userLoginRequest = new UserLoginRequest();
//            userLoginRequest.setUserAccount("admin");
//            userLoginRequest.setUserPassword("12345678");
//
//            System.out.println("远程代码沙箱");
//            String url = "http://localhost:8102/api/user/login";
//            String json = JSONUtil.toJsonStr(userLoginRequest);
//            String responseStr = HttpUtil.createPost(url)
//                    .body(json)
//                    .execute()
//                    .body();
//            if(StringUtils.isBlank(responseStr)){
//                System.out.println("请求失败");
//                throw new BusinessException(ErrorCode.API_REQUEST_ERROR, "executeCode remoteSandbox error, message = " + responseStr);
//            }
//
//        System.out.println(responseStr);


//        test1();
        test2();
            return;
    }

    // 测试远程代码
    public static void test1() {

        String code = "public class Main {\n" +
                "    public static void main(String[] args) {\n" +
                "\n" +
                "        try {\n" +
                "            // 将参数转换为整数\n" +
                "            int num1 = Integer.parseInt(args[0]);\n" +
                "            int num2 = Integer.parseInt(args[1]);\n" +
                "\n" +
                "            // 计算两个数的和\n" +
                "            int sum = num1 + num2;\n" +
                "\n" +
                "            // 输出结果\n" +
                "            System.out.println(sum);" +
                "        } catch (NumberFormatException e) {\n" +
                "            // 如果转换失败，输出错误信息\n" +
                "            System.out.println(\"输入的参数不是有效的整数。\");\n" +
                "        }\n" +
                "    }\n" +
                "}";

        ExecuteCodeRequest request = new ExecuteCodeRequest();
        request.setInputList(List.of(new String[]{"1 2"}));
        request.setCode(code);
        request.setLanguage("java");

        System.out.println("远程代码沙箱");
//        String url = "http://" + host + ":8090/executeCode";
        String url = "http://" + host + ":8090/executeCodeDocker";
        String json = JSONUtil.toJsonStr(request);
        String responseStr = HttpUtil.createPost(url)
                .header(AUTH_REQUEST_HEADER, AUTH_REQUEST_SECRET)
                .body(json)
                .execute()
                .body();
        if(StringUtils.isBlank(responseStr)){
            System.out.println("请求失败");
            throw new BusinessException(ErrorCode.API_REQUEST_ERROR, "executeCode remoteSandbox error, message = " + responseStr);
        }

        System.out.println(responseStr);

    }

    @Data
    public static class UserLoginRequest implements Serializable {

        private static final long serialVersionUID = 3191241716373120793L;

        private String userAccount;

        private String userPassword;
    }

    private static boolean test2(){
        String a = "0";

        int y = Integer.parseInt(a);

        int x = 1;

        // 负数和以0结尾的正数不是回文数（除了0本身）
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        // 反转整数的一半
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // 对于奇数长度的整数，去掉中间的数字后再比较
        // 例如，对于12321，我们反转成123，然后与12321的前半部分123比较
        return x == reversedHalf || x == reversedHalf / 10;
    }

}
