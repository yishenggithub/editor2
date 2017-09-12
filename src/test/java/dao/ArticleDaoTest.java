package dao;

import model.Article;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by easom on 2017/9/8.
 */
public class ArticleDaoTest {
    @Test
    public void testSave() throws Exception {
        ArticleDao articleDao=new ArticleDao();
        Article article=new Article();
        article.setTitle("test");
        article.setContent("test");
        articleDao.saveAticle(article);
    }
    @Test
    public  void testList() throws Exception {
        ArticleDao articleDao=new ArticleDao();
        List<Article> result=articleDao.listAticle();
        System.out.println(result.get(1).getTitle()+","+result.get(1).getContent());
    }
    @Test
    public void testDelete() throws Exception{
        ArticleDao articleDao=new ArticleDao();

        articleDao.delete(2);
    }

    @Test
    public void testShow() throws SQLException {
        ArticleDao articleDao=new ArticleDao();
        Article article=articleDao.show(23);
        System.out.println(article.getTitle()+article.getContent());
    }
}
