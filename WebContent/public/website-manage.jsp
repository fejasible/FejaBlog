<!DOCTYPE HTML>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags" %>

<html lang="en-US">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<title>${ config.blogName }</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/public/style/images/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/public/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/style/css/media-queries.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/style/js/player/mediaelementplayer.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/public/style/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/style/js/ddsmoothmenu.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/style/js/retina.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/style/js/selectnav.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/style/js/jquery.masonry.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/style/js/jquery.fitvids.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/style/js/jquery.backstretch.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/style/js/mediaelement.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/style/js/mediaelementplayer.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/style/js/jquery.dcflickr.1.0.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/style/js/twitter.min.js"></script>
<script type="text/javascript">
	function getRootPath_dc() {
	    var pathName = window.location.pathname.substring(1);
	    var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
	    if (webName == "") {
	        return window.location.protocol + '//' + window.location.host;
	    }
	    else {
	        return window.location.protocol + '//' + window.location.host + '/' + webName;
	    }
	}
	$.backstretch(getRootPath_dc()+"/public/style/images/bg/9.jpg");
</script>
</head>
	<body>
		<%@include file="/public/menu.jsp" %>
		<div class="wrapper">
			
			
			<div class="content box">
				<h4>博客配置</h4>
				<div class="box">
					<form:form id="config_form" commandName="config" action="${pageContext.request.contextPath}/admin/website/manage/edit" method="post">
						<table>
							<tr><td><h5>博客名称:&emsp;</h5></td><td width="85%"><form:input id="blog_name" path="blogName"></form:input></td></tr>
							<tr><td><p> </p></td></tr>
							<tr><td><h5>博客描述:&emsp;</h5></td><td><form:input id="blog_describe" path="blogDescribe"></form:input></td></tr>
							<tr><td><p> </p></td></tr>
							<tr><td><h5>版权声明:&emsp;</h5></td><td><form:textarea id="copyright" path="copyright"></form:textarea></td></tr>
							<tr><td><p> </p></td></tr>
							<tr><td><h5>博客简介:&emsp;</h5></td><td><form:input id="profile" path="profile"></form:input></td></tr>
							<tr><td><p> </p></td></tr>
						</table>
						<form:button type="submit">提交</form:button>
						<p> </p>
					</form:form>
				</div>
				
			</div>
			
			<div class="sidebar box">
				<%@include file="/public/module/admin-option.jsp" %>
			</div>
			
				
				
				
		</div>
		
		<div class="clear"></div>
		<%@include file="/public/footer.jsp" %>
		<script type="text/javascript" src="${pageContext.request.contextPath}/public/style/js/scripts.js"></script>
	</body>
	
	<script src="${pageContext.request.contextPath}/public/style/js/util.js"></script>
</html>