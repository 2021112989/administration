package com.len.core.BootListener;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyApplicationListener implements ApplicationListener<ContextRefreshedEvent> {


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("-------------bean初始化完毕-------------");
        /**
         * 通过线程开启数据库中已经开启的定时任务 灵感来自spring
         * spring boot继续执行 mythread开辟线程，延迟后执行
         */
        DataSourceJobThread myThread = (DataSourceJobThread) event.getApplicationContext().getBean(
                "dataSourceJobThread");
        myThread.start();
    }

}
