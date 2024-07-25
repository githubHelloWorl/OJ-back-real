package com.example;

import com.yupi.yuoj.MainApplication;
import com.yupi.yuoj.manager.AIManager;
import com.yupi.yuoj.manager.SparkManager;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest(classes = MainApplication.class)
public class SparkManagerTest {
    @Resource
    private AIManager aiManager;

    @Resource
    private SparkManager sparkManager;


    private final String userInput =
            "public class Main {\n" +
                    "    public static void main(String[] args) {\n" +
                    "\n" +
                    "        try {\n" +
                    "            // 将参数转换为整数\n" +
                    "            int num1 = Integer.parseInt(args[0]);\n" +
                    "            int num2 = Integer.parseInt(args[1]);\n" +
                    "            int num = num1 - num2 - 10;\n" +
                    "            System.out.println(num);\n" +
                    "        } catch (NumberFormatException e) {\n" +
                    "            // 如果转换失败，输出错误信息\n" +
                    "            System.out.println(\"输入的参数不是有效的整数。\");\n" +
                    "        }\n" +
                    "    }\n" +
                    "}【java【4 5,7 8,-7 7,12 0";

    @Test
    public void testApi() {

        String result = sparkManager.sendMesToAIUseXingHuo(userInput);

        System.out.println("我们得到的结果:");
        System.out.println(result);
    }

    @Test
    public void testYu(){
        String result = aiManager.doChat(userInput);

        System.out.println("我们得到的结果:");
        System.out.println(result);
    }
}
