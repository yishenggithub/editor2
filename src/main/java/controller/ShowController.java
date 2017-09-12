package controller;

import dao.ArticleDao;
import model.Article;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by easom on 2017/9/7.
 */
public class ShowController {
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws SQLException {
    /*    Article article=new Article();
        article.setContent(request.getParameter("content"));
        article.setTitle(request.getParameter("title"));

        ArticleDao articleDao=new ArticleDao();
        try {
            articleDao.saveAticle(article);
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
        Integer bid=  Integer.parseInt(String.valueOf(request.getParameter("bid")));


        ArticleDao articleDao=new ArticleDao();

        Article article=articleDao.show(bid);

        request.setAttribute("article",article);

        return "/view/show.jsp";
    }
}
