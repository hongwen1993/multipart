package com.kagura;


import com.kagura.dao.UserMapper;
import com.kagura.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/8 15:53
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test01 {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01() {
        User user = userMapper.selectByPrimaryKey(1);
        System.err.println(user);
    }


}
