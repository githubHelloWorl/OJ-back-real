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
        test1();
//        test2();
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

        String codeC = "#include <stdio.h>\n" +
                "\n" +
                "int main(int argc, char *argv[]) {\n" +
                "    // 检查是否提供了两个参数\n" +
                "    if (argc != 3) {\n" +
                "        printf(\"Usage: %s <number1> <number2>\\n\", argv[0]);\n" +
                "        return 1;\n" +
                "    }\n" +
                "\n" +
                "    // 将参数转换为整数\n" +
                "    int num1 = atoi(argv[1]);\n" +
                "    int num2 = atoi(argv[2]);\n" +
                "\n" +
                "    // 相加\n" +
                "    int sum = num1 + num2;\n" +
                "\n" +
                "    // 输出结果\n" +
                "    printf(\"%d\",sum);\n" +
                "\n" +
                "    return 0;\n" +
                "}";

        String codeCpp = "#include <iostream>\n" +
                "#include <cstdlib> // 包含 std::stoi 函数\n" +
                "\n" +
                "using namespace std;\n" +
                "\n" +
                "int main(int argc, char *argv[]) {\n" +
                "    // 检查是否提供了两个参数\n" +
                "    if (argc != 3) {\n" +
                "        cout << \"Usage: \" << argv[0] << \" <number1> <number2>\" << endl;\n" +
                "        return 1;\n" +
                "    }\n" +
                "\n" +
                "    try {\n" +
                "        // 将参数转换为整数\n" +
                "        int num1 = stoi(argv[1]);\n" +
                "        int num2 = stoi(argv[2]);\n" +
                "\n" +
                "        // 相加\n" +
                "        int sum = num1 + num2;\n" +
                "\n" +
                "        // 输出结果\n" +
                "        cout << sum << endl;\n" +
                "    } catch (const invalid_argument& ia) {\n" +
                "        cerr << \"Invalid argument: \" << ia.what() << endl;\n" +
                "        return 1;\n" +
                "    } catch (const out_of_range& oor) {\n" +
                "        cerr << \"Out of range error: \" << oor.what() << endl;\n" +
                "        return 1;\n" +
                "    }\n" +
                "\n" +
                "    return 0;\n" +
                "}";

        String codePy = "import sys\n" +
                "\n" +
                "# 定义一个函数来执行两数相加\n" +
                "def add_two_numbers(num1, num2):\n" +
                "    return num1 + num2\n" +
                "\n" +
                "if len(sys.argv) != 3:\n" +
                "    print(\"使用方法: python3 test.py <number1> <number2>\")\n" +
                "    sys.exit(1)\n" +
                "\n" +
                "                # 从命令行参数获取两个数字\n" +
                "                # sys.argv[0] 是脚本名称，sys.argv[1] 和 sys.argv[2] 是数字\n" +
                "first_number = int(sys.argv[1])\n" +
                "second_number = int(sys.argv[2])\n" +
                "\n" +
                "                # 调用函数并打印结果\n" +
                "result = add_two_numbers(first_number, second_number)\n" +
                "print(f\"{result}\")\n";

        ExecuteCodeRequest request = new ExecuteCodeRequest();
        request.setInputList(List.of(new String[]{"1 2"}));
        request.setCode(codePy);
        request.setLanguage("python");

        System.out.println("远程代码沙箱");
        String url = "http://" + host + ":8090/executeCode";
//        String url = "http://" + host + ":8090/executeCodeDocker";
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
