package com.lmk.orange.vo;

import lombok.Data;

import java.util.List;

/**
 * @author WangShijun
 * @date 2020/6/5 9:30
 */
@Data
public class FeedbackListVo {

    private List<String> FeedbackIdList;

    private String reply;
}
