package com.amber.spring.scheduling;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

public class Schedule implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        Trigger trigger = getTrigger();
        scheduledTaskRegistrar.addTriggerTask(trigger);
    }

    public Trigger getTrigger() {
        //从数据库读出所有定时任务
        if ("updateUser".equals("updateUser")) {
            Runnable runnable = new Runnable();
        }
    }
}
