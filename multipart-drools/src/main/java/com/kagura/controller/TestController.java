package com.kagura.controller;

import com.kagura.utils.KieSessionUtils;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/10 15:57
 * @since 1.0.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/01")
    public String test01() throws Exception {
        KieSession kieSession = KieSessionUtils.newKieSession("D:\\_Temp\\rule.drl");
        kieSession.insert(999d);
        kieSession.fireAllRules();
        return "OK";
    }


    @RequestMapping("/02")
    public String test02() throws Exception {
        String str = KieSessionUtils.getDRL("D:\\_Temp\\rule.xls");
        System.out.println(str);

        String str1 = "package rule;\n" +
                "//generated from Decision Table\n" +
                "// rule values at B10, header at B5\n" +
                "rule \"ID change_10\"\n" +
                "\tno-loop true\n" +
                "\twhen\n" +
                "\t\t$d : Double($d == 0)\n" +
                "\tthen\n" +
                "\t\tSystem.out.println(\"没有理智的刀客塔\");\n" +
                "end\n" +
                "\n" +
                "// rule values at B11, header at B5\n" +
                "rule \"ID change_11\"\n" +
                "\tno-loop true\n" +
                "\twhen\n" +
                "\t\t$d : Double($d == 999)\n" +
                "\tthen\n" +
                "\t\tSystem.out.println(\"真正刀客塔\");\n" +
                "end";
        KieSession kieSession = KieSessionUtils.createKieSessionFromDRL(str1);
        kieSession.insert(999d);
        kieSession.fireAllRules();
        return "OK";
    }


}
