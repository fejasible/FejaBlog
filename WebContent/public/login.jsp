<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE HTML>
<html lang="en-US">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<title>${ config.blogName }</title>
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/public/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/style/css/media-queries.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/style/js/player/mediaelementplayer.css" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,400italic,300italic,300,700,700italic|Open+Sans+Condensed:300,700' rel="stylesheet" type='text/css'>
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
		<div class="box">
			<form:form commandName="config" action="${ pageContext.request.contextPath }/login" method="post">
				<div><p>用户名<form:input type="text" value="" path="username"/></p></div>
				<div><p>&nbsp;密码<form:input type="password" value="" path="password"/></p></div>
				<div>
					<input type="submit" value="登录">
				</div>
				<c:if test="${ loginResult!=null }">
					<div style="text-align:center"><a>${ loginResult }</a></div>
				</c:if>
			</form:form>
		<div><p> </p></div>
		</div>
	</div>
<%@include file="/public/footer.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/style/js/scripts.js"></script>
</body>
</html>