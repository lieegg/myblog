package com.my.blog.website.controller.admin;

import com.my.blog.website.controller.BaseController;
import com.my.blog.website.exception.TipException;
import com.my.blog.website.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * 大数据插入测试
 */
@Controller
@RequestMapping("/bigData")
@Transactional(rollbackFor = TipException.class)
public class BigDataTestController extends BaseController {
    @Resource
    private IUserService userService;

    /**
     * 保存
     */
    @PostMapping(value = "/insertMysql")
    @ResponseBody
    public String insertMysql(@RequestParam Map<String,Object> userMap) {
        List list= Arrays.asList((String) userMap.get("LIST"));
        Map listMap = (Map) list.get(0);
        for (int i=0;i<=list.size();i++){
            listMap = (Map) list.get(i);
//            userService.insertPT_QX_USER(listMap);
        }
        return "操作成功";
    }
}
