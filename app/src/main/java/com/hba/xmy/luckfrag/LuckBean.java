package com.hba.xmy.luckfrag;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: HBA
 * @Time: 2020/12/30 17:27
 * @Describe:
 */
@NoArgsConstructor
@Data
public class LuckBean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"type":"综合指数","content":"90%"},{"type":"爱情指数","content":"90%"},{"type":"工作指数","content":"80%"},{"type":"财运指数","content":"80%"},{"type":"健康指数","content":"80%"},{"type":"幸运颜色","content":"蓝色"},{"type":"幸运数字","content":"1"},{"type":"速配Ｑ友","content":"双子"},{"type":"今日概述","content":"今天的双子宝宝们可以说是最幸福的人了，无论遇到什么事情都会被解决。可以出去游玩的宝宝们当然是抓紧时间好好地享受旅游啦，说不定会在途中遇到对自己有帮助的人噢。要加班的宝宝今天的合作运不错，不如趁着运势，跟合作方谈谈合作吧。"}]
     */

    private int code;
    private String msg;
    private List<NewslistBean> newslist;

    @NoArgsConstructor
    @Data
    public static class NewslistBean {
        /**
         * type : 综合指数
         * content : 90%
         */

        private String type;
        private String content;
    }
}
