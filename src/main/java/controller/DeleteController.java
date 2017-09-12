package controller;

import dao.ArticleDao;
import db.DBUtil;
import model.Article;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by easom on 2017/9/9.
 */
public class DeleteController {
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
       // System.out.println(request.getAttribute("bid"));
        Integer bid=  Integer.parseInt(String.valueOf(request.getParameter("bid")));

        ArticleDao articleDao=new ArticleDao();
        articleDao.delete(bid);

        return "list.action";

    }
}
