package com.musketeer.ten.Beans;

import com.musketeer.ten.http.HttpParser;

import org.xutils.http.annotation.HttpResponse;

import java.util.List;

/**
 * Created by Kevin on 2016/9/21.
 */
@HttpResponse(parser = HttpParser.class)
public class DiagramBean {

    /**
     * result : [{"id":100042,"type":3,"publishtime":636100992000000000,"title":"芳香","summary":"在哪里存在，就在哪里绽放。不要因为难过，就忘了散发芳香。","image":"images/8765E704113855DB698C46F8732D7E55.jpg"},{"id":100041,"type":3,"publishtime":636100128000000000,"title":"有味道的色彩","summary":"记忆不是固体，它是拂过叶片的风，是握在手中的沙，总有一些缝隙任它自由穿梭，一种味道、一种声音或者一种色彩\u2026\u2026","image":"images/E9CCB3910F44B11A466A732D63964775.jpg"},{"id":100040,"type":3,"publishtime":636099264000000000,"title":"色彩明快","summary":"我已经偷偷的习惯了这种色彩的日子。也许是我变得软弱了吧，但我真的不想再失去了。没关系，就算没有我，这世界上仍然有她，仍然是彩色的。这就够了。","image":"images/2E04D46E7E722068E43CC9A0784400BF.jpg"},{"id":100039,"type":3,"publishtime":636098400000000000,"title":"喵星人一定是上天派来卖萌的吧","summary":"我始终相信，在这个世界上，一定有另一个自己，在做着我不敢做的事，在过着我想过的生活。","image":"images/A69AA0E5A8C9E977847813DA9B5E53D9.jpg"},{"id":100037,"type":3,"publishtime":636097536000000000,"title":"灵动的美","summary":"人生就是不断地放下，然而痛心的是，我还没来得及与你们好好告别。","image":"images/6F801AB1357EF5F7D36EE20B6E9A64BB.jpg"},{"id":100038,"type":3,"publishtime":636096672000000000,"title":"那个人","summary":"遇上那个人的时候，我们以为自己会爱他一辈子，他已经这么好了，我怎可能爱上别人？然而，岁月会让你知道，一辈子的心愿，真的只是一个心愿。","image":"images/3F9F5AF15F279C995BD54FCCD86E4147.jpg"},{"id":100036,"type":3,"publishtime":636094944000000000,"title":"山山唯落晖","summary":"如果一个想法在一开始不是荒谬的，那它就是没有希望的。","image":"images/7246EBF0D898E9919E0013EB3196E8A6.jpg"},{"id":100034,"type":3,"publishtime":636094080000000000,"title":"有些呆萌有些可爱","summary":"人并不是因为美丽才可爱，而是因为可爱才美丽。","image":"images/C795D5927E4E664C77191FA96C8E1E28.jpg"},{"id":100033,"type":3,"publishtime":636093216000000000,"title":"我不想谋生，我想生活","summary":"I don't want to survive,I want to live. \r\n\r\n我不想生存,我想生活。\r\n","image":"images/C689C6BDF2291D99A6F7DB86EB2BE455.jpg"}]
     * status : 0
     * errMsg : null
     */

    private int status;
    private Object errMsg;
    /**
     * id : 100042
     * type : 3
     * publishtime : 636100992000000000
     * title : 芳香
     * summary : 在哪里存在，就在哪里绽放。不要因为难过，就忘了散发芳香。
     * image : images/8765E704113855DB698C46F8732D7E55.jpg
     */

    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private int id;
        private int type;
        private long publishtime;
        private String title;
        private String summary;
        private String image;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public long getPublishtime() {
            return publishtime;
        }

        public void setPublishtime(long publishtime) {
            this.publishtime = publishtime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
