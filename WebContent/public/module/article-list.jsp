<%@page import="com.feja.blog.model.Article"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.feja.blog.model.ArticleType"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="themes-block-1">
	<div>
		<c:if test="${ directArticleType != null }">
			分类:${ directArticleType.type }
		</c:if>
		<c:if test="${ directArticleDate != null }">
			日期:${ directArticleDate }
		</c:if>
	</div>
	<c:forEach items="${ articles }" var="article">
		<div class="themes-block-1 layout-article-1" 
		onclick="window.location.href='${ pageContext.request.contextPath }/article/view/${ article.id }';return false;">
			标题：${ article.title }&nbsp;&nbsp;
			分类：${ article.articleTypeId }&nbsp;&nbsp;
			创建时间：<fmt:formatDate value="${ article.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
			<hr>
			${ article.content }
		</div>
	</c:forEach>
	<div align="center"><a href="">上一页</a>&nbsp;&nbsp;1&nbsp;&nbsp;2&nbsp;&nbsp;3&nbsp;&nbsp;<a href="">下一页</a></div>
</div>