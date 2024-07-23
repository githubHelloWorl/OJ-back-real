package com.yupi.yuoj.judge.codesandbox.impl;

import com.yupi.yuoj.judge.codesandbox.CodeSandbox;
import com.yupi.yuoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.yupi.yuoj.judge.codesandbox.model.ExecuteCodeResponse;
import com.yupi.yuoj.judge.codesandbox.model.JudgeInfo;
import com.yupi.yuoj.manager.AIManager;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 调用大模型接口
 */
public class AICodeSandbox implements CodeSandbox {

    @Resource
    private AIManager aiManager;

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("AI 调用");

        // 构造需求
        // {待分析代码，语言，参数}（以上每部分使用 ， 隔离）
        // (参数使用空格隔离，第一个是总参数个数，其后为第2,3,4... 个参数)
        List<String> inputList = executeCodeRequest.getInputList();
        String code = executeCodeRequest.getCode();
        String language = executeCodeRequest.getLanguage();

        String requestMessage = code + "【" + language;
        for(int i = 0; i < inputList.size(); ++i){
            if(i == 0){
                requestMessage += ("【" + inputList.get(i));
            } else {
                requestMessage += ("," + inputList.get(i));
            }
        }

        // 调用AI
        String ansResponse =  aiManager.doChat(requestMessage);

        // 处理返回结果
        ExecuteCodeResponse response = new ExecuteCodeResponse();
        String[] splits = ansResponse.split("【【【");
        if(splits.length < 2){
//            throw new BusinessException(ErrorCode.SYSTEM_ERROR,"AI 生成错误");
            response.setStatus(0);
            response.setMessage("AI 生成错误");
            return response;
        }

        String ans = splits[1].trim(); // 1
        String[] temp = ans.split("\n");
        String[] ansList = Arrays.copyOf(temp, temp.length - 1);

        response.setOutputList(List.of(ansList));
        response.setStatus(2);
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage("");
        judgeInfo.setTime(0L);
        judgeInfo.setMemory(0L);
        response.setJudgeInfo(judgeInfo);

        System.out.println("结果是:");
        System.out.println(response);

        return response;
    }

    public static void main(String[] args){
        ExecuteCodeRequest executeCodeRequest = new ExecuteCodeRequest();
        executeCodeRequest.setCode("a");
        executeCodeRequest.setLanguage("java");
        executeCodeRequest.setInputList(Arrays.asList("1 2","8 9","-15 -100","569 -569"));

        AICodeSandbox aiCodeSandbox = new AICodeSandbox();
        ExecuteCodeResponse response = aiCodeSandbox.executeCode(executeCodeRequest);
        System.out.println(response);
    }
}
