package com.hba.xmy.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class URLContent {
//     星座配对接口
    public static String getParnterURL(String men,String woman){
        men = men.replace("座","");
        woman = woman.replace("座","");
        try {
            men = URLEncoder.encode(men,"UTF-8");
            woman = URLEncoder.encode(woman,"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String url = "http://apis.juhe.cn/xzpd/query?men="+men+"&women="+woman+"&key=aab7f23b9a6149ef03e1b8136e38b640";
        return url;
    }

//    星座运势接口
    public static String getLuckURL(String name){
        String enName=getEnglishName(name);
//        try {
//            enName = URLEncoder.encode(enName,"UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        String url = "http://api.tianapi.com/txapi/star/index?astro="+enName+"&key=dd90b3249e4753cee208f71ff4bdb59e";
        return url;

    }

    /**
     * 名字转英文
     * @param cnName
     * @return
     */
    public static String getEnglishName(String cnName){
        /**
         * 十二星座英文名：
         * aries 白羊座,
         * taurus 金牛座,
         * gemini 双子座,
         * cancer 巨蟹座,
         * leo 狮子座,
         * virgo 处女座,
         * libra 天秤座,
         * scorpio 天蝎座,
         * sagittarius 射手座,
         * capricorn ,摩羯座,
         * aquarius 水瓶座,
         * pisces 双鱼座。
         */
        String enName="";
        if (cnName=="白羊座"){
            enName="aries";
        }
        if (cnName=="金牛座"){
            enName="taurus";
        }
        if (cnName=="双子座"){
            enName="gemini";
        }
        if (cnName=="巨蟹座"){
            enName="cancer";
        }
        if (cnName=="狮子座"){
            enName="leo";
        }
        if (cnName=="处女座"){
            enName="virgo";
        }
        if (cnName=="天秤座"){
            enName="libra";
        }
        if (cnName=="天蝎座"){
            enName="scorpio";
        }
        if (cnName=="射手座"){
            enName="sagittarius";
        }
        if (cnName=="摩羯座"){
            enName="capricorn";
        }
        if (cnName=="水瓶座"){
            enName="aquarius";
        }
        if (cnName=="双鱼座"){
            enName="pisces";
        }
        return enName;
    }
}
