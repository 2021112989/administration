package com.len.core.filter;

import com.len.base.CurrentUser;
import com.len.service.MenuService;
import com.len.service.SysUserService;
import java.io.IOException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class PermissionFilter extends AuthorizationFilter {

  @Autowired
  private SysUserService userService;

  @Autowired
  private MenuService menuService;

  @Override
  protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse,
      Object o) throws Exception {
    String[] roles=(String[])o;

    Subject sub = getSubject(servletRequest, servletResponse);
    Session session= sub.getSession();
    CurrentUser user= (CurrentUser) session.getAttribute("currentPrincipal");
    log.info("user:{}",user);
    if(user==null) {
      return false;
    }
    return true;
  }

  @Override
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response)
      throws IOException {
      saveRequest(request);
      WebUtils.issueRedirect(request, response, "/goLogin");
    return false;
  }
}
