<!DOCTYPE HTML>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
			<h4>草稿箱</h4>
				<div class="box">
					<table>
						<tr>
							<th align="center">&emsp;&emsp;标题&emsp;&emsp;</th>
							<th align="center">&emsp;&emsp;继续编辑&emsp;&emsp;</th>
							<th align="center">&emsp;&emsp;彻底删除&emsp;&emsp;</th>
						</tr>
						<c:forEach items="${ articles }" var="article">
							<tr>
								<td align="center"><a href="${pageContext.request.contextPath}/blog/${article.articleId}">${ article.title }</a></td>
								<td align="center"><a href="${pageContext.request.contextPath}/admin/article/edit/${article.articleId}">编辑</a></td>
								<td align="center">
									<c:if test="${ article.visible == 1 }"><a href="${pageContext.request.contextPath}/admin/article/manage/visible/${ article.articleId }">不可见</a></c:if>
									<c:if test="${ article.visible == 0 }"><a href="${pageContext.request.contextPath}/admin/article/manage/visible/${ article.articleId }">可见</a></c:if>
								</td>
								<td align="center">
									<% boolean flag = true; %>
									<c:forEach items="${ recommendArticles }" var="recommendArticle">
										<c:if test="${ article.articleId == recommendArticle.articleId }"><% flag = false; %><a href="${pageContext.request.contextPath}/admin/article/manage/recommend/${ article.articleId }">已推荐</a></c:if>
									</c:forEach>
									<c:if test="<%= flag == true %>"><a href="${pageContext.request.contextPath}/admin/article/manage/recommend/${ article.articleId }">未推荐</a></c:if>
								</td>
							</tr>
						</c:forEach>
					</table>
					<div><p> </p></div>
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