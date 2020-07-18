package com.kagura.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.kagura.model.UserInfo;
import com.kagura.dao.UserInfoMapper;
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

    
    public int deleteByPrimaryKey(Integer id) {
        return userInfoMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(UserInfo record) {
        return userInfoMapper.insert(record);
    }

    
    public int insertSelective(UserInfo record) {
        return userInfoMapper.insertSelective(record);
    }

    
    public UserInfo selectByPrimaryKey(Integer id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(UserInfo record) {
        return userInfoMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(UserInfo record) {
        return userInfoMapper.updateByPrimaryKey(record);
    }

}
