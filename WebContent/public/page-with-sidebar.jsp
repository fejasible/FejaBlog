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
<script type="text/javascript" src="${pageContext.request.contextPath}/public/plugin/editorue/third-party/SyntaxHighlighter/shCore.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/plugin/editorue/third-party/SyntaxHighlighter/shCoreDefault.css">
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
	SyntaxHighlighter.all();
</script>

</head>
<body>

<%@include file="/public/menu.jsp" %>

<div class="wrapper">
<div class="content box">
	<h1 class="title">${ article.title }</h1>
	<p>${ article.content }</p>
</div>
<div class="sidebar box">
  <div class="sidebox widget">
			<h3 class="widget-title">推荐文章</h3>
			<ul class="post-list">
				<c:forEach items="${ recommendArticles }" var="article">
				  	<li> 
						<div class="meta">
						    <h6><a href="${pageContext.request.contextPath}/blog/${ article.articleId }">${ article.title }</a></h6>
						    <em><fmt:formatDate value="${ article.date }" pattern="yyyy-MM-dd"/></em>
					    </div>
					</li>
				</c:forEach>
			</ul>
			
	</div>
</div>
<!--End Sidebar -->
<div class="clear"></div>

</div>
<!-- End Wrapper -->
<%@include file="/public/footer.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/style/js/scripts.js"></script>
</body>
</html>