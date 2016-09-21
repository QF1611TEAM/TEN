package com.musketeer.ten.Beans;

/**
 * Created by Kevin on 2016/9/21.
 */
public class NovelBean {

    /**
     * id : 100037
     * title : 少女来自茵梦湖
     * author : 清池蛙
     * authorbrief : 清池蛙
     这里有世界上最温柔的故事
     * times : 5635
     * summary : 任是不识亦动人
     * text : 1.阿昭是高二6班一个不起眼的存在。....(完)
     * image :
     * publishtime : 636099264000000000
     * status : 0
     * errMsg : null
     */

    private int id;
    private String title;
    private String author;
    private String authorbrief;
    private int times;
    private String summary;
    private String text;
    private String image;
    private long publishtime;
    private int status;
    private Object errMsg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorbrief() {
        return authorbrief;
    }

    public void setAuthorbrief(String authorbrief) {
        this.authorbrief = authorbrief;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(long publishtime) {
        this.publishtime = publishtime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(Object errMsg) {
        this.errMsg = errMsg;
    }
}
