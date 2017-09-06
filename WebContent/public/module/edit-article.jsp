<%@page import="java.util.Comparator"%>
<%@page import="com.feja.blog.model.ArticleType"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/style/js/article.js"></script>
<form:form id="article_form" commandName="article" action="${pageContext.request.contextPath}/admin/article/edit/${ article.articleId }" method="post">
	<form:hidden path="articleId"/>
	<form:hidden path="visible"/>
	<h4>编辑文章</h4>
	<div class="box">
		<table>
			<tr><td><h5>文章  ID ：</h5></td><td>${ article.articleId }</td></tr>
			<tr><td><h5>编辑标题：</h5></td><td><form:input path="title"></form:input></td></tr>
			<tr><td><h5>编辑分类：</h5></td><td><form:input path="typeString"/></td></tr>
			<c:if test="${ article.visible==0 }"><tr><td><h5>是否可见：</h5></td><td>是</td></tr></c:if>
			<c:if test="${ article.visible==1 }"><tr><td><h5>是否可见：</h5></td><td>否</td></tr></c:if>
			<c:if test="${ article.visible!=0 && article.visible!=1 }"><tr><td><h5>是否可见：</h5></td><td>默认不可见，请在文章管理中设置</td></tr></c:if>
		</table>
		<div><p> </p></div>
	</div>
		
    <!-- 加载编辑器的容器 -->
    <script id="container" type="text/plain">${ article.content }</script>
    <!-- 配置文件 -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/public/plugin/editorue/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/public/plugin/editorue/ueditor.all.js"></script>
    <!-- 实例化编辑器 -->
    <script type="text/javascript">
        var ue = UE.getEditor('container');
        UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;  
        UE.Editor.prototype.getActionUrl = function(action) {  
            if (action == 'uploadfile') {  
                return '${pageContext.request.contextPath}/admin/ueditor/uploadfile';  
            } else {  
                return this._bkGetActionUrl.call(this, action);  
            }
        }
    </script>
	<div><p> </p></div>
	<div class="box" style="text-align:center">
		<form:button type="submit">确认修改</form:button>
		<div><p> </p></div>
	</div>
</form:form>