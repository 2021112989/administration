package com.len.core.BootListener;

import com.len.core.quartz.JobTask;
import com.len.entity.SysJob;
import com.len.service.JobService;
import com.len.util.SpringUtil;
import com.len.service.RoleService;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class DataSourceJobThread extends Thread {

    @Autowired
    RoleService roleService;

    @Autowired
    JobService jobService;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            log.info("---------线程启动---------");
            JobTask jobTask = SpringUtil.getBean("jobTask");
            SysJob job = new SysJob();
            job.setStatus(true);
            List<SysJob> jobList = jobService.selectListByPage(job);
            //开启任务
            jobList.forEach(jobs -> {
                        log.info("---任务[" + jobs.getId() + "]系统 init--开始启动---------");
                        jobTask.startJob(jobs);
                    }
            );
            if (jobList.size() == 0) {
                log.info("---数据库暂无启动的任务---------");
            } else
                System.out.println("---任务启动完毕---------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
