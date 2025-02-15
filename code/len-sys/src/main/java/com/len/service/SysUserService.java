package com.len.service;


import com.len.base.BaseService;
import com.len.entity.SysRoleUser;
import com.len.entity.SysUser;
import com.len.util.Checkbox;
import com.len.util.JsonUtil;
import java.util.List;

public interface SysUserService extends BaseService<SysUser,String> {

  SysUser login(String username);


  SysUser selectByPrimaryKey(String id);

  /**
   * 分页查询
   * @param
   * @return
   */
  @Override
  List<SysUser> selectListByPage(SysUser sysUser);

  int count();

  /**
   * 新增
   * @param user
   * @return
   */
  int add(SysUser user);

  /**
   * 删除
   * @param id
   * @return
   */
  JsonUtil delById(String id,boolean flag);

  int checkUser(String username);



  @Override
  int updateByPrimaryKey(SysUser sysUser);

  List<SysRoleUser> selectByCondition(SysRoleUser sysRoleUser);

  public List<Checkbox> getUserRoleByJson(String id);

  /**
   * 更新密码
   * @param user
   * @return
   */
  int rePass(SysUser user);


  List<SysUser> getUserByRoleId(String roleId);

  public void setMenuAndRoles(String username);

  public void updateCurrent(SysUser user);
}
