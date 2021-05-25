package com.kagura.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.kagura.model.UserInfo;
import com.kagura.dao.UserInfoMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * $description
 * 
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date   2020/5/19 23:59
 * @since 1.0.0
 */
@Service
public class UserInfoService{

    @Resource
    private UserInfoMapper userInfoMapper;

    // REQUIRED  REQUIRES_NEW  NESTED
    @Transactional(propagation = Propagation.NESTED, rollbackFor = Exception.class)
    public void f() {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(1000002);
        userInfo.setName("b");
        userInfoMapper.updateByPrimaryKey(userInfo);
        int a = 0/0;
    }


}
