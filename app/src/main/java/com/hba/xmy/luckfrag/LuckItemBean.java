package com.hba.xmy.luckfrag;

import lombok.Data;

/**
 * @Author: HBA
 * @Time: 2020/12/30 17:32
 * @Describe:
 */
@Data
public class LuckItemBean {
    private String title;
    private String content;
    private int colorId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }
    //    private String comprehensive;
//    private String love;
//    private String work;
//    private String money;
//    private String health;
//    private String lucklyColor;
//    private String lucklyNum;
//    private String  Qfriend;

}
