<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML>
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
<div class="intro">${ config.blogDescribe }</div>
<div class="content box">

	<h1 class="title">联系我</h1>

	<div class="form-container">
		<form class="forms" action="${pageContext.request.contextPath}/contact/contactMe" method="post">
			<fieldset>
				<ol>
					<li class="form-row text-input-row"><label>您的昵称</label><input type="text" name="nickname" value="" class="text-input required" title="" /></li> 
					<li class="form-row text-input-row"><label>您的邮件地址</label><input type="text" name="email" value="" class="text-input required email" title="" /></li> 
					<li class="form-row text-input-row"><label>标题</label><input type="text" name="title" value="" class="text-input required" title="" /></li> 
					<li class="form-row text-area-row"><label>内容</label><textarea name="content" class="text-area required"></textarea></li> 
					<li class="button-row"><input type="submit" value="发送" name="submit" class="btn-submit" /></li>
				</ol>
			</fieldset>
		</form>
	</div>
</div>
<div class="sidebar box">
	<div class="sidebox widget">
		<h3 class="widget-title">简介</h3>
		<p>${ config.profile }</p>
	</div>
</div>
<div class="clear"></div>
</div>

<%@include file="/public/footer.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/style/js/scripts.js"></script>
</body>
</html>