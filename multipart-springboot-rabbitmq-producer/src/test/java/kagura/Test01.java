package kagura;

import kagura.entity.User;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/5 13:54
 * @since 1.0.0
 */
public class Test01 {

    @Test
    public void test01() {
        Map<String, User> map = new HashMap<>();
        String a = "hhh";
        User user = new User();
        user.setName("kagura");
        user.setAge(2);
        map.put(a, user);
        Map<String, User> map2 = new HashMap<>(map);
        Map<String, User> map3 = Collections.unmodifiableMap(map);
        // 三个map相同,但是map的地址不同,但是map中的元素地址相同
        System.out.println("map1 => " + map);
        System.out.println("map2 => " + map2);
        System.out.println("map3 => " + map3);

        User user2 = new User();
        user2.setName("yeshenyue");
        map.put("www", user2);
        System.out.println("map1 => " + map);
        System.out.println("map2 => " + map2);
        System.out.println("map3 => " + map3);

        User u = map2.get("hhh");
        u.setName("eee");
        System.out.println("map1 => " + map);
        System.out.println("map2 => " + map2);
        System.out.println("map3 => " + map3);

        //map1 => {hhh={"name":"kagura","age":2}}
        //map2 => {hhh={"name":"kagura","age":2}}
        //map3 => {hhh={"name":"kagura","age":2}}
        //map1 => {www={"name":"yeshenyue","age":null}, hhh={"name":"kagura","age":2}}
        //map2 => {hhh={"name":"kagura","age":2}}
        //map3 => {www={"name":"yeshenyue","age":null}, hhh={"name":"kagura","age":2}}
        //map1 => {www={"name":"yeshenyue","age":null}, hhh={"name":"eee","age":2}}
        //map2 => {hhh={"name":"eee","age":2}}
        //map3 => {www={"name":"yeshenyue","age":null}, hhh={"name":"eee","age":2}}
    }


}
