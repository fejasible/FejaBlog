package com.feja.blog.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.feja.blog.constant.BlogConstant;
import com.feja.blog.controller.Controller;
import com.feja.blog.model.Article;
import com.feja.blog.model.Type;
import com.feja.blog.model.form.AddArticleForm;

@org.springframework.stereotype.Controller
public class ArticleController extends Controller{
	private Log logger = LogFactory.getLog(ArticleController.class);
	
	/**
	 * 页面 添加文章
	 * @return
	 */
	@RequestMapping(value="/admin/article/add", method=RequestMethod.GET)
	public ModelAndView addArticle(){
		ModelAndView modelAndView = new ModelAndView("admin-view");
		modelAndView.addObject("article", new AddArticleForm(new Article()));
		this.renderHeaderAndFooter(modelAndView);
		return modelAndView;
	}
	
	
	/**
	 * 操作 添加文章
	 * @param article
	 * @param typeString
	 * @return
	 */
	@RequestMapping(value="/admin/article/add/{typeString:.*}", method=RequestMethod.POST)
	public String addArticle(Article article, @PathVariable String typeString){
		int articleId = service.addArticle(article);
		service.addTypeToArticle(articleId, typeString);
		return "redirect:/admin/article/manage";
	}
	
	
	
	/**
	 * 页面 编辑文章
	 * @return
	 */
	@RequestMapping(value="/admin/article/edit/{articleId:[0-9]*}", method=RequestMethod.GET)
	public ModelAndView editArticle(@PathVariable int articleId){
		ModelAndView modelAndView = new ModelAndView("admin-view");
		Article article = service.getArticle(articleId);
		List<Type> types = service.getTypeByArticleId(article.getArticleId());
		String typeString = "";
		for(Type type: types){
			typeString += type.getType() + ";";
		}
		AddArticleForm addArticleForm = new AddArticleForm(article);
		addArticleForm.setArticleId(articleId);
		addArticleForm.setTypeString(typeString);
		modelAndView.addObject("article", addArticleForm);
		this.renderHeaderAndFooter(modelAndView);
		return modelAndView;
	}
	
	
	/**
	 * 页面 文章管理
	 * @return
	 */
	@RequestMapping(value="/admin/article/manage", method=RequestMethod.GET)
	public ModelAndView articleManage(){
		ModelAndView modelAndView = new ModelAndView("article-manage");
		ArrayList<Article> articles = service.getAllArticlesNotDelete();
		ArrayList<AddArticleForm> addArticleForms = new ArrayList<>();
		for(Article article: articles){
			AddArticleForm addArticleForm = new AddArticleForm(article);
			List<Type> types = service.getTypeByArticleId(article.getArticleId());
			String typeString = "";
			for(Type type: types){
				typeString += type.getType() + ";";
			}
			addArticleForm.setTypeString(typeString);
			addArticleForms.add(addArticleForm);
		}
		modelAndView.addObject("articles", addArticleForms);
		renderHeaderAndFooter(modelAndView);
		return modelAndView;
	}
	
	
	/**
	 * 操作 改变文章的可见状态
	 * @param articleId
	 */
	@RequestMapping(value="/admin/article/manage/visible/{articleId:[0-9]*}", method=RequestMethod.GET)
	public String articleManageSetVisible(@PathVariable int articleId){
		Article article = service.getArticle(articleId);
		if(article.getVisible() == BlogConstant.IS_VISIBLE){
			service.updateArticleVisible(articleId, false);
			service.updateArticleToRecommend(articleId, false);
		}else{
			service.updateArticleVisible(articleId, true);
		}
		return "redirect:/admin/article/manage";
	}
	
	
	/**
	 * 操作 改变文章的推荐状态
	 * @param articleId
	 * @return
	 */
	@RequestMapping(value="/admin/article/manage/recommend/{articleId:[0-9]*}", method=RequestMethod.GET)
	public String articleManageSetRecommand(@PathVariable int articleId){
		if(service.isArticleRecommend(articleId)){
			service.updateArticleToRecommend(articleId, false);
		}else{
			service.updateArticleToRecommend(articleId, true);
			service.updateArticleVisible(articleId, true);
		}
		return "redirect:/admin/article/manage";
	}
	
	
	/**
	 * 操作 将文章放入回收站
	 * @param articleId
	 * @return
	 */
	@RequestMapping(value="/admin/article/manage/delete/{articleId:[0-9]*}", method=RequestMethod.GET)
	public String deleteArticle(@PathVariable int articleId){
		service.deleteArticle(articleId, true);
		service.updateArticleVisible(articleId, false);
		service.updateArticleToRecommend(articleId, false);
		return "redirect:/admin/article/manage";
	}

	/**
	 * 操作 将文章从回收站中恢复
	 * @param articleId
	 * @return
	 */
	@RequestMapping(value="admin/recycleBin/manage/recover/{articleId:[0-9]*}", method=RequestMethod.GET)
	public String recoverArticle(@PathVariable int articleId){
		service.deleteArticle(articleId, false);
		return "redirect:/admin/recycleBin/manage";
	}
	
	/**
	 * 操作 彻底删除文章
	 * @param articleId
	 * @return
	 */
	@RequestMapping(value="admin/recycleBin/manage/destroy/{articleId:[0-9]*}", method=RequestMethod.GET)
	public String destroyArticle(@PathVariable int articleId){
		service.destroyArticle(articleId);
		return "redirect:/admin/recycleBin/manage";
	}

	

	/**
	 * 请求 添加文章
	 * @param editorValue
	 * @return
	 */
	@RequestMapping(value="/admin/article/add", method=RequestMethod.POST)
	public String addArticle(@RequestParam String editorValue, AddArticleForm articleForm){
		
		logger.info(editorValue);
		logger.info(articleForm.toString());
		logger.info(articleForm.getArticleId());
		
		if(articleForm.getArticleId() == null || articleForm.getArticleId() == 0){//添加文章
			Article article = articleForm.getArticle();
			article.setContent(editorValue);
			int articleId = service.addArticle(article);
			service.addType(articleForm.getTypeString());
			service.addTypeToArticle(articleId, articleForm.getTypeString());
		}else{//编辑文章
			Article article = articleForm.getArticle();
			article.setContent(editorValue);
			service.editArticle(article);
		}
		return "redirect:/admin/article/manage";
	}
	
	
	/**
	 * 请求 编辑文章
	 * @param articleId
	 * @return
	 */
	@RequestMapping(value="/admin/article/edit/{articleId:[0-9]*}", method=RequestMethod.POST)
	public String editArticle(@PathVariable int articleId, @RequestParam String editorValue, AddArticleForm articleForm){
		Article article = articleForm.getArticle();
		article.setContent(editorValue);
		service.editArticle(article);
		return "redirect:/admin/article/manage";
	}
	
}
