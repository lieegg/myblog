package com.my.blog.website.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by zhangyan on 2018/4/17.
 */
public class ParamsSign {

    /**
     * 生成数字签名
     * @param params 参数map
     * @param seckey 密钥
     * @return 签名值
     */
    public static String getSign(Map params, String seckey){
        String signkey = "sign";//数字签名的key
        TreeMap<String,String> treemap = new TreeMap<String,String>();
        treemap.putAll(params);
        StringBuffer pastr = new StringBuffer();
        for(String key:treemap.keySet()){//treemap升序取key
            if(key!=null&&!key.equals(signkey)) {//去掉数字签名
                pastr.append(key).append("=").append(treemap.get(key)).append("&");
            }
        }
        pastr.append("=").append(seckey);//追加密钥
//        System.out.println("明文:"+pastr);
        String res = null;
        try {
            res = MD5Utils.md5(pastr.toString());//MD5摘要，32位小写
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("app_id","qykh");
        map.put("hhhh","asldfkj");
        map.put("bai","1111111");
        map.put("zdi","22222");
        map.put("timestamp", String.valueOf(new Date().getTime()));
        map.put("sdi","333");
        String sign = getSign(map,"abcdefg");
        System.out.println(sign);
    }

}
