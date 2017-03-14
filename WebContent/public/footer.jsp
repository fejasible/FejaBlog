<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags" %>
<div class="footer-wrapper">
	<div id="footer" class="three">
		<div id="first" class="widget-area">
			<%-- 日期归档 --%>
			<div class="widget widget_archive">
				<h3 class="widget-title">日期归档</h3>
				<ul>
				<c:forEach items="${ dates }" var="date">
					<li><a href=<st:url value="/date/${ date.date }"></st:url>>${ date.date }</a>(${ date.num })</li>
				</c:forEach>
				</ul>
			</div>
			<div class="widget widget_search">
				<h3 class="widget-title">搜索</h3>
				<form class="searchform" method="get" action="#">
					<input type="text" name="s" value="type and hit enter" onFocus="this.value=''" onBlur="this.value='type and hit enter'"/>
				</form>
			</div>
		</div>
		<div id="second" class="widget-area">
			<div class="widget widget_archive">
				<h3 class="widget-title">分类归档</h3>
				<ul>
				<c:forEach items="${ types }" var="type">
					<li><a href=<st:url value="/type/${ type.type }"></st:url>>${ type.type }</a>(${ type.num })</li>
				</c:forEach>
				</ul>
			</div>	
		</div>
		<div id="third" class="widget-area">
			<div id="example-widget-3" class="widget example">
				<h3 class="widget-title">推荐文章</h3>
				<ul class="post-list">
					<c:forEach items="${ recommendArticles }" var="article">
						<li> 
							<div class="meta">
							    <h6><a href="#">${ article.title }</a></h6>
							    <em>${ article.date }</em>
						    </div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</div>
<div class="site-generator-wrapper">
	<div class="site-generator">${ config.copyright }</div>
</div>
