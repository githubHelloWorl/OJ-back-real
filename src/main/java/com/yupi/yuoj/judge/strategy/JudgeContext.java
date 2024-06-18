package com.yupi.yuoj.judge.strategy;

import com.yupi.yuoj.model.dto.question.JudgeCase;
import com.yupi.yuoj.judge.codesandbox.model.JudgeInfo;
import com.yupi.yuoj.model.entity.Question;
import com.yupi.yuoj.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * 上下文（用于定义在策略中传递的参数）
 */
@Data
public class JudgeContext {

    /**
     * 代码沙箱 返回结果
     */
    private JudgeInfo judgeInfo;

    /**
     * 判断输入参数
     */
    private List<String> inputList;

    /**
     * 判断输出参数
     */
    private List<String> outputList;

    /**
     * 获取输入用例
     */
    private List<JudgeCase> judgeCaseList;

    /**
     * 问题
     */
    private Question question;

    /**
     * 问题提交
     */
    private QuestionSubmit questionSubmit;

}
