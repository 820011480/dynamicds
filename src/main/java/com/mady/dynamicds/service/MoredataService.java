package com.mady.dynamicds.service;

import com.mady.dynamicds.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author mady
 * @date 2018/11/06
 */

public interface MoredataService {

    public List<User> getAllUser1();

    public List<User> getAllUser2();

    public int addUserGetID1(User user);

    public int addUserGetID2(User user);
}
