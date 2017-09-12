package controller;

import dao.ArticleDao;
import model.Article;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by easom on 2017/9/10.
 */
public class SaveController {
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Article article=new Article();
        article.setContent(request.getParameter("content"));
        article.setTitle(request.getParameter("title"));

        ArticleDao articleDao=new ArticleDao();

        articleDao.saveAticle(article);

        return "list.action";
    }
}
