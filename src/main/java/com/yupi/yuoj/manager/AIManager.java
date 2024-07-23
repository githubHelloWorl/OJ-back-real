package com.yupi.yuoj.manager;

import com.yupi.yucongming.dev.client.YuCongMingClient;
import com.yupi.yucongming.dev.model.DevChatRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;

@Service
public class AIManager {

    @Resource
    private YuCongMingClient yuCongMingClient;

    /**
     * AI 对话
     *
     * @param message
     * @return
     */
    public String doChat(String message) {
        String id = "1";
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

        String ans = "【【【\n3\n17\n-115\n0\n【【【";

        // TODO 获得结果
        return ans;
    }
}
