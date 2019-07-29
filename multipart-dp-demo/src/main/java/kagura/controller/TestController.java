package kagura.controller;

import kagura.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    User user;

    @GetMapping(path = "/01")
    public Object test01() throws Exception {
        System.out.println(user);
        return 0;
    }



}
