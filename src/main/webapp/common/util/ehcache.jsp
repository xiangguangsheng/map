<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<html>
  <head>
    <meta charset="utf-8">
	<title>ehcache</title>
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
          <th>cache</th>
          <th>&nbsp;</th>
        </tr>
      </thead>
      <tbody>
        <tr>
	      <td>${cache}</td>
	      <td><a href="ehcache.jsp?name=${cache.name}">view</a></td>
	    </tr>
      </tbody>
    </table>
	<br>
    <table border="1" width="100%">
      <thead>
        <tr>
          <th>index</th>
          <th>key</th>
          <th>value</th>
        </tr>
      </thead>
      <tbody>
        <tr>
	      <td>${index}</td>
	      <td>${key}</td>
	      <td></td>
	    </tr>
      </tbody>
    </table>
  </body>
</html>
