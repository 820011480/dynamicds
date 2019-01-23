package com.mady.dynamicds.controller;

import com.mady.dynamicds.model.User;
import com.mady.dynamicds.service.MoredataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author mady
 * @date 2018/11/06
 */
@RestController
@RequestMapping("/moredata")
public class MoredataController {
    @Autowired
    private MoredataService moredataServiceimpl;
 
    @RequestMapping(value = "/getDb1AllUser")
    public List<User> getDb1AllUser() {
        List<User> list = moredataServiceimpl.getAllUser1();
        return list;
    }
 
    @RequestMapping(value = "/getDb2AllUser")
    public List<User> getDb2AllUser() {
        List<User> list = moredataServiceimpl.getAllUser2();
        return list;
    }
 
    @RequestMapping(value = "/addDb1User")
    public String addDb1User(String name) {
        User user = new User(1, "user1" , new Date());
        int count = moredataServiceimpl.addUserGetID1(user);//返回的是结果行数
        return "{count:"+count+"}";
    }
    @RequestMapping(value = "/addDb2User")
    public String addDb2User(String name) {
        User user = new User(1 , "user2" ,new Date());
        int count = moredataServiceimpl.addUserGetID2(user);
        return "{count:"+count+"}";
    }
 
}
