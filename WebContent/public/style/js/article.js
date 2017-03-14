/**
 * 保存草稿
 */

function saveDraft(){
	var article_form = document.getElementById("article_form");
	article_form.setAttribute("action", getRootPath()+"/admin/article/draft/save");
	article_form.submit();
}

/**
 * 查看草稿
 */
function viewDraft(){
	var article_form = document.getElementById("article_form");
	article_form.setAttribute("action", getRootPath()+"/admin/article/draft/view");
	article_form.submit();
}

/**
 * 确认添加文章
 */
function addArticle(ue){
	var article_form = document.getElementById("article_form");
	article_form.setAttribute("article", ue.getContent());
	article_form.setAttribute("action", getRootPath()+"/admin/article/add");
	article_form.submit();
}
