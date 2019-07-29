package kagura.config;

import kagura.entity.User;
import org.springframework.context.annotation.Bean;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/7/29 16:25
 * @since 1.0.0
 */
public class TestConfig01 {
    @Bean
    public User user() {
        User user = new User();
        user.setName("Karas");
        user.setAge(20);
        return user;
    }
}
