package controller;

import dao.ArticleDao;
import model.Article;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;

/**
 * Created by easom on 2017/8/16.
 */
public class ListController {

    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ArticleDao articleDao=new ArticleDao();
        List<Article> articleList=articleDao.listAticle();
        Collections.reverse(articleList);
        request.setAttribute("articleList",articleList);
        return "/view/home.jsp";
    }
}
