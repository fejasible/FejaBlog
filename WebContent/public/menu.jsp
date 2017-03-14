<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="scanlines"></div>
<div class="header-wrapper opacity">
	<div class="header">
		<div class="logo">
		    <a href="${pageContext.request.contextPath}/admin/view">
				<img src="${pageContext.request.contextPath}/public/style/images/logo.png" alt="" />
			</a>
	    </div>
		<div id="menu-wrapper">
			<div id="menu" class="menu">
				<ul id="tiny">
					<li class="active"><a href="${pageContext.request.contextPath}/index">首页</a>
						<ul>
							<li><a href="public/post.html">Blog Post</a></li>
						</ul>
					</li>
					<li><a href="${pageContext.request.contextPath}/blog/0">博客</a>
						<ul>
							<li><a href="${pageContext.request.contextPath}/public/page-with-sidebar.jsp">Page With Sidebar</a></li>
							<li><a href="${pageContext.request.contextPath}/public/full-width.html">Full Width</a></li>
						</ul>
					</li>
					<li><a href="${pageContext.request.contextPath}/profile">简介</a>
						<ul>
							<li><a href="${pageContext.request.contextPath}/public/typography.html">Typography</a></li>
							<li><a href="${pageContext.request.contextPath}/public/columns.html">Columns</a></li>
						</ul>
					</li>
					<li><a href="${pageContext.request.contextPath}/contact">联系我</a></li>
				</ul>
			</div>
		</div>
		<div class="clear"></div>
		<!-- End Menu -->
	</div>
</div>