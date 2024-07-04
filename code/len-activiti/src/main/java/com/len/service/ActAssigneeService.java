package com.len.service;

import com.len.base.BaseService;
import com.len.entity.ActAssignee;
import org.activiti.engine.impl.pvm.process.ActivityImpl;

import java.util.List;

public interface ActAssigneeService extends BaseService<ActAssignee,String> {
  int deleteByNodeId(String nodeId);

  public List<ActivityImpl> getActivityList(String deploymentId);

  public  List<ActivityImpl> selectAllActivity(List<ActivityImpl> activities);

}
