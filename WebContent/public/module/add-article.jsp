<%@page import="java.util.Comparator"%>
<%@page import="com.feja.blog.model.ArticleType"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/style/js/article.js"></script>
<form:form id="article_form" commandName="article">
	<h4>添加文章</h4>
	<div class="box">
		<div><h5>编辑标题：</h5><form:input path="title"></form:input></div>
		<div><p> </p></div>
		<h5>编辑分类：</h5><input id="type"></input>
		<div><p> </p></div>
		<h5>是否可见：</h5>
		<div style="float:left">
			<p>是</p><input type="radio" name="test" checked="checked"/>
			<p>否</p><input type="radio" name="test" />
		</div>
	</div>
		
	    <!-- 加载编辑器的容器 -->
	    <script id="container" type="text/plain">编辑内容...</script>
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
		<a class="button green" style="opacity: 1;" onclick="javascript:addArticle(ue)">发表文章</a>
		<a class="button blue" style="opacity: 1;" onclick="javascript:saveDraft()">保存草稿</a>
	</div>
</form:form>