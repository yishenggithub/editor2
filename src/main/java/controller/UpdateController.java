package controller;

import dao.ArticleDao;
import model.Article;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by easom on 2017/9/12.
 */
public class UpdateController {
    public String handleRequest(HttpServletRequest request, HttpServletResponse resp) throws SQLException {

        Article article=new Article();
        article.setContent(request.getParameter("content"));
        article.setTitle(request.getParameter("title"));

        Integer bid=  Integer.parseInt(String.valueOf(request.getParameter("bid")));
        article.setBid(bid);

        ArticleDao articleDao=new ArticleDao();

        articleDao.updateAticle(article);

        return "list.action";
    }
}
