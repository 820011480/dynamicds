package com.mady.dynamicds.service;

import com.mady.dynamicds.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * dao层
 * Created by pure on 2018-05-06.
 */

public interface MoredataService {
    public List<User> getAllUser1();
    public List<User> getAllUser2();
    public int addUserGetID1(User user);
    public int addUserGetID2(User user);
}
