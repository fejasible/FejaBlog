<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags" %>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
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
<div class="box">
	<ul>
		<li><a href="${ pageContext.request.contextPath }/index">返回主页</a></li>
		<li><a href="${ pageContext.request.contextPath }/admin/article/add">添加文章</a></li>
		<li><a href="${ pageContext.request.contextPath }/admin/article/manage">文章管理</a></li>
		<li><a href="${ pageContext.request.contextPath }/admin/type/manage">类别管理</a></li>
		<li><a href="${ pageContext.request.contextPath }/admin/website/manage">博客配置</a></li>
		<li><a href="${ pageContext.request.contextPath }/admin/draft/manage">草稿箱</a></li>
		<li><a href="${ pageContext.request.contextPath }/admin/recycleBin/manage">回收站</a></li>
		<li><a href="${ pageContext.request.contextPath }/admin/logout">登出</a></li>
	</ul>
</div>