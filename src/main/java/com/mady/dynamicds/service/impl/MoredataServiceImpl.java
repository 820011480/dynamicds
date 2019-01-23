package com.mady.dynamicds.service.impl;

import com.mady.dynamicds.config.DS;
import com.mady.dynamicds.mapper.MoredataMapper;
import com.mady.dynamicds.model.User;
import com.mady.dynamicds.service.MoredataService;
import org.springframework.stereotype.Service;
/**
 * @author mady
 * @date 2018/11/06
 */
import javax.annotation.Resource;
import java.util.List;

/**
 * @author mady
 * @date 2018/11/06
 */
@Service
public class MoredataServiceImpl implements MoredataService {

    @Resource //moredataDao 与接口名称对应不上 使用@Resource 注解 或者使用@Autowired @Qualifier
    private MoredataMapper moredataDao;

    @Override
    public List<User> getAllUser1() {
        return moredataDao.getAllUser1();
    }

    @Override
    @DS("datasource2")
    public List<User> getAllUser2() {
        return moredataDao.getAllUser2();
    }

    @Override
    @DS("datasource1")
    public int addUserGetID1(User user) {
       return moredataDao.addUserGetID1(user);
    }

    @Override
    @DS("datasource2")
    public int addUserGetID2(User user){
        return moredataDao.addUserGetID2(user);
    }
}
