<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.security.access.ConfigAttribute"%>
<%@page import="org.springframework.security.access.method.MethodSecurityMetadataSource"%>
<%@page import="org.springframework.security.access.method.DelegatingMethodSecurityMetadataSource"%>
<%
    ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(application);
	DelegatingMethodSecurityMetadataSource delegatingMethodSecurityMetadataSource =
		(DelegatingMethodSecurityMetadataSource) ctx.getBean("org.springframework.security.access.method.DelegatingMethodSecurityMetadataSource#0");

	List<MethodSecurityMetadataSource> methodSecurityMetadataSources = delegatingMethodSecurityMetadataSource.getMethodSecurityMetadataSources();
%>
<html>
  <head>
    <meta charset="utf-8">
	<title>auth-method</title>
    <style>
tbody tr:nth-child(odd) td,
tbody tr:nth-child(odd) th {
  background-color: #f9f9f9;
}
    </style>
  </head>
  <body>
    <table border="1" width="100%">
      <thead>
        <tr>
          <th>url</th>
          <th>perm</th>
        </tr>
      </thead>
      <tbody>
      </tbody>
    </table>
  </body>
</html>
