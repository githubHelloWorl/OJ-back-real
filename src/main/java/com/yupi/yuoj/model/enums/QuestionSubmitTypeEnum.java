package com.yupi.yuoj.model.enums;

public enum QuestionSubmitTypeEnum {
    REMOTE("remote"),
    REMOTE_DOCKER("remoteDocker"),
    AI("AI");

    private String value;

    QuestionSubmitTypeEnum(String value) {
        this.value = value;
    }

    public static QuestionSubmitTypeEnum getEnumByValue(String text){
        for(QuestionSubmitTypeEnum anEnum : QuestionSubmitTypeEnum.values()){
            if(anEnum.getValue().equals(text)){
                return anEnum;
            }
        }
        return null;
    }

    public String getValue(){
        return this.value;
    }
}
