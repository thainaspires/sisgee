<!doctype html>
<html lang="en">
  <head>
    <%@ include file="head_imports.jspf" %>
    <title><fmt:message key="br.cefetrj.sisgee.index.title"/></title>
  </head>
  <body>
  	<%@ include file="menu.jspf" %>
  	<div class="container">
  		<br/>
  		<c:if test="${ not empty sucesso }">
	 		<div class="alert" style="margin-top: 20px; background: #B8B3CC;">${ sucesso }</div>		
	 	</c:if>

  		<p><fmt:message key="br.cefetrj.sisgee.index.msg"/></p>
  	</div>
    <%@ include file="scripts_imports.jspf" %>
  </body>
</html>
