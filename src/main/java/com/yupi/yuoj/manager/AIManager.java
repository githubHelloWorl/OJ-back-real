package com.yupi.yuoj.manager;

import com.yupi.yucongming.dev.client.YuCongMingClient;
import com.yupi.yucongming.dev.model.DevChatRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AIManager {
    @Value("${myAI.id}")
    private String id;

    @Resource
    private YuCongMingClient yuCongMingClient;

    /**
     * AI 对话
     * @param message
     * @return
     */
    public String doChat(String message){
        DevChatRequest devChatRequest = new DevChatRequest();
        devChatRequest.setModelId(Long.parseLong(id));
        devChatRequest.setMessage(message);

        //        BaseResponse<DevChatResponse> response = yuCongMingClient.doChat(devChatRequest);
//        System.out.println("AI 分析:");
//        System.out.println(response);
//        if(response == null){
//            throw new BusinessException(ErrorCode.SYSTEM_ERROR,"AI 响应异常");
//        }
//
//        return response.getData().getContent();

        // TODO 获得结果
        return "";
    }
}
