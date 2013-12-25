<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Map"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.security.access.ConfigAttribute"%>
<%@page import="org.springframework.security.web.access.intercept.FilterSecurityInterceptor"%>
<%@page import="org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource"%>
<%@page import="org.springframework.security.web.util.RequestMatcher"%>
<html>
  <head>
    <meta charset="utf-8">
	<title>auth-url</title>
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
    <tr>
	  <td>${entry.key}</td>
	  <td>${entry.value}</td>
	</tr>
<%
%>
      </tbody>
    </table>
  </body>
</html>
