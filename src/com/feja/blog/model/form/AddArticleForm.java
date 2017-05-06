package com.feja.blog.model.form;

import java.util.Date;

import com.feja.blog.model.Article;
import com.feja.blog.util.JsonUtil;

public class AddArticleForm{
	
	private String typeString;
	
	private Integer articleId;

    private String title;

    private Integer isDelete;

    private Integer isDraft;

    private Integer visible;

    private Date date;

    private String content;
    
    private Article article;


    public AddArticleForm(){
    	
    }
    
    
    public AddArticleForm(Article article){
    	this.articleId = article.getArticleId();
    	this.title = article.getTitle();
    	this.isDelete = article.getIsDelete();
    	this.isDraft = article.getIsDraft();
    	this.visible = article.getVisible();
    	this.date = article.getDate();
    	this.content = article.getContent();
    	this.article = article;
    }
    
    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIsDraft() {
        return isDraft;
    }

    public void setIsDraft(Integer isDraft) {
        this.isDraft = isDraft;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
    

	public String getTypeString() {
		return typeString;
	}

	public void setTypeString(String typeString) {
		this.typeString = typeString;
	}


	public Article getArticle() {
		Article article = new Article();
		article.setArticleId(articleId);
		article.setContent(content);
		article.setDate(date);
		article.setIsDelete(isDelete);
		article.setIsDraft(isDraft);
		article.setTitle(title);
		article.setVisible(visible);
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@Override
	public String toString() {
		return JsonUtil.writeValueAsString(this);
	}
}
