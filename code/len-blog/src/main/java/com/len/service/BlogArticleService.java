package com.len.service;

import com.len.base.BaseService;
import com.len.entity.ArticleDetail;
import com.len.entity.BlogArticle;
import com.len.model.Article;
import com.len.util.JsonUtil;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

public interface BlogArticleService extends BaseService<BlogArticle, String> {

    List<Article> indexSelect();

    public JsonUtil getDetail(String code);

    public JsonUtil detail(String code,String ip);

    List<Article> selectArticle(String code);

    List<Article> selectArticleByTag(String tagCode);

    BlogArticle selectPrevious(Date date);

    BlogArticle selectNext(Date date);

    boolean addArticle(ArticleDetail articleDetail);

    boolean updateArticle(Article article,List<String> categoryIds,List<String> tags);

}
