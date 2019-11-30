package com.kagura;


import com.drools.core.KieTemplate;
import org.junit.Test;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/11/30
 * @since 1.0.0
 */
public class Second extends Base{

    @Autowired
    private KieTemplate kieTemplate;

    @Test
    public void test01() {
        KieSession kieSession = kieTemplate.getKieSession("rule.drl");
        kieSession.insert(0d);
        kieSession.fireAllRules();
    }

}
