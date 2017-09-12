package model;

/**
 * Created by easom on 2017/8/14.
 */
public class Article {

    private String content;
    private String title;
    private Integer bid;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle(){return title;}

    public void setTitle(String title){this.title=title;}

}