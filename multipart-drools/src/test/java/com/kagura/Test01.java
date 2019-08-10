package com.kagura;

import com.kagura.utils.KieSessionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/10 1:13
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DroolsApplication.class)
public class Test01 {

    @Test
    public void test01() throws Exception {
        //KieSession kieSession = KieSessionUtils.newKieSession("rules/rule2.drl");
        //kieSession.insert(0d);
        //kieSession.fireAllRules();

        KieSession kieSession = KieSessionUtils.newKieSession("D:\\_Temp\\rule.drl");
        kieSession.insert(999d);
        kieSession.fireAllRules();


    }
}
