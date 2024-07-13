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
 * 第三方代码沙箱（调用网上现成的代码沙箱）
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

        String requestMessage = code + "," + language;
        for(String input: inputList){
            requestMessage += ("," + input);
        }

        // 调用AI
        String ansResponse =  aiManager.doChat(requestMessage);

        // 处理返回结果
        ExecuteCodeResponse response = new ExecuteCodeResponse();
        String[] splits = ansResponse.split("【【【\n");
        if(splits.length < 3){
//            throw new BusinessException(ErrorCode.SYSTEM_ERROR,"AI 生成错误");
            response.setStatus(0);
            response.setMessage("AI 生成错误");
            return response;
        }

        String ans = splits[1]; // 1
        String[] temp = ans.split("\n");
        String[] ansList = Arrays.copyOf(temp, temp.length - 1);

        response.setOutputList(List.of(ansList));
        response.setStatus(2);
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage("");
        judgeInfo.setTime(0L);
        judgeInfo.setMemory(0L);
        response.setJudgeInfo(judgeInfo);

        return response;
    }
}
