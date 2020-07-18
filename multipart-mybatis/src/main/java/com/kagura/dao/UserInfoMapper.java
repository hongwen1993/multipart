package com.kagura.dao;

import com.kagura.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * $description
 * 
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date   2020/5/19 23:59
 * @since 1.0.0
 */
@Mapper
public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}