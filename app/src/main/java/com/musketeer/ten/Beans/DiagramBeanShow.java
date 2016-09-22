package com.musketeer.ten.Beans;

/**
 * Created by Hey on 2016/9/22.
 */
public class DiagramBeanShow {

    /**
     * id : 100041
     * title : 有味道的色彩
     * author : Hiroshi Matsumoto
     * authorbrief : 来自艺术家 Hiroshi Matsumoto
     * text1 : 记忆不是固体，它是拂过叶片的风，是握在手中的沙，总有一些缝隙任它自由穿梭，一种味道、一种声音或者一种色彩……
     * image1 : images/E9CCB3910F44B11A466A732D63964775.jpg
     * text2 : —美丫《在封存的记忆里温暖回忆》
     * times : 4990
     * publishtime : 636100128000000000
     * status : 0
     * errMsg : null
     */

    private int id;
    private String title;
    private String author;
    private String authorbrief;
    private String text1;
    private String image1;
    private String text2;
    private int times;
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

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
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
