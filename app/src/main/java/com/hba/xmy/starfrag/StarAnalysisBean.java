package com.hba.xmy.starfrag;

import lombok.Data;

/**
 * @Author: HBA
 * @Time: 2020/12/29 17:29
 * @Describe:
 */
@Data
public class StarAnalysisBean {
    private  String title;
    private  String content;
    private  int color;

    public StarAnalysisBean(String title, String content, int color) {
        this.title = title;
        this.content = content;
        this.color = color;
    }

}
