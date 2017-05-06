/**
 * 确认添加文章
 */
function addArticle(ue){
	var article_form = document.getElementById("article_form");
	article_form.setAttribute("article", ue.getContent());
	article_form.setAttribute("action", getRootPath()+"/admin/article/add");
	article_form.submit();
}


/**
 * 确认更新配置
 */
function updateConfig(){
	var config_form = document.getElementById("config_form");
	article_form.setAttribute("action", getRootPath()+"/admin/website/manage/edit");
	article_form.submit();
}

