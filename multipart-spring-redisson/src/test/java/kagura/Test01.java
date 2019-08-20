package kagura;


import kagura.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/8 15:53
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test01 {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test01() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");

        User user = new User(1L, "karas", 18, new Date());
        redisTemplate.opsForValue().set("test:t01", user);
    }


}
