package com.my.blog.website;

import com.my.blog.website.utils.Get16BM;
import com.my.blog.website.utils.HttpClientUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.util.*;

public class KHTest {
    public static void main(String[] args) {
        Map pa = new HashMap();
        Map userList = new HashMap();
        List<Map> list = new ArrayList();
        pa.put("timestamp",String.valueOf(new Date().getTime()));
        try {
            int count = 11;
            Long startTime = new Date().getTime();
            System.out.println("开始时间"+startTime);
            int num = 0;
            for (int i=0;i<=count;i++){
                Map userMap = new HashMap();
                //加密方式，默认MD5，可选SHA
                String hashAlgorithmName = "MD5";
                int hashIterations = 1024;
                String username = "admin"+i;
                String credentials = "111111";
                ByteSource credentialsSalt = ByteSource.Util.bytes(username);
                Object obj = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);
                String userid = Get16BM.getUnquieID();
                userMap.put("userid",userid);
                userMap.put("username",username);
                userMap.put("czry_dm",userid);
                userMap.put("password",obj.toString());
                userMap.put("mtype","1");
                userMap.put("isclosed","0");
                userMap.put("isdelete","0");
                userMap.put("kllx","1");
                userMap.put("seclevel","1");
                userMap.put("accountid","1");
                list.add(userMap);
                num++;
                if(num % 10==0){
                    userList.put("LIST", list);
                    Long endTime_print = new Date().getTime();
                    String res = HttpClientUtil.httpPostRequest("http://localhost:8080/bigData/insertMysql",userList);
                    System.out.println("第"+(num)+"条-----------耗时："+(endTime_print-startTime)/1000);
                    System.out.println("第"+(num)+"条返回结果："+res);
                    list = new ArrayList();
                }
            }
            Long endTime = new Date().getTime();
            System.out.println(count+"条数据插入结束时间："+endTime);
            System.out.println(count+"条数据插入耗时(毫秒)："+(endTime-startTime)+"毫秒");
            System.out.println(count+"条数据插入耗时(秒)："+(endTime-startTime)/1000+"秒");
            System.out.println(count+"条数据插入耗时(分钟)："+(endTime-startTime)/60000+"分钟");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
