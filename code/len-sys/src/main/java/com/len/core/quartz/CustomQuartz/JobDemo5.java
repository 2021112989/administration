package com.len.core.quartz.CustomQuartz;

import com.len.entity.SysUser;
import com.len.service.SysUserService;
import com.len.service.impl.SysUserServiceImpl;
import com.len.util.SpringUtil;
import java.text.SimpleDateFormat;
import java.util.List;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;

public class JobDemo5 implements Job{


  @Override
  public void execute(JobExecutionContext context) throws JobExecutionException {
    System.out.println("JobDemo5：启动任务=======================");
    run();
    System.out.println("JobDemo5：下次执行时间====="+
        new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
            .format(context.getNextFireTime())+"==============");
  }

  public void run(){
    ApplicationContext applicationContext=SpringUtil.getApplicationContext();
    SysUserService sys=SpringUtil.getBean(SysUserServiceImpl.class);
    List<SysUser> userList=sys.selectListByPage(new SysUser());
    System.out.println(userList.get(0).getUsername());;
    System.out.println("JobDemo5：执行完毕=======================");

  }
}
