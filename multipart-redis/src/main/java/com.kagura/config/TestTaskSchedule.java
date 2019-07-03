package com.kagura.config;

import org.apache.commons.lang.StringUtils;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

/**
 * 不可以使用@Schedule,一个文件算一个定时任务
 * - 实现SchedulingConfigurer
 * @author kagura
 */
@Component
public class TestTaskSchedule implements SchedulingConfigurer {

    /**
     * cron表达式,最好设置初始值,否则容易失效
     */
    private String cron = "0/10 * * * * ?";

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        // 增加当前任务
        taskRegistrar.addTriggerTask(
                () -> {
                    // TODO
                    System.out.println(System.currentTimeMillis());
                    System.out.println("OK");
                },
                (triggerContext) -> {
                    if (StringUtils.isBlank(cron)) {
                        return null;
                    }
                    // 定时任务触发，可修改定时任务的执行周期
                    CronTrigger trigger = new CronTrigger(cron);
                    // nextExecutionTime方法主要用于设置下一次的执行时间
                    // 由此可见,spring的定时任务,执行一次之后,每次再评估下一次执行时间
                    return trigger.nextExecutionTime(triggerContext);
                });
    }

}
