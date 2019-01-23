package com.mady.dynamicds.mapper;

import com.mady.dynamicds.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MoredataMapper {


    List<User> getAllUser1();

    List<User> getAllUser2();

    int addUserGetID1(User user);

    int addUserGetID2(User user);
}
