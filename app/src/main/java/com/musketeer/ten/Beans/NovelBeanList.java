package com.musketeer.ten.Beans;

import java.util.List;

/**
 * Created by Kevin on 2016/9/21.
 */
public class NovelBeanList {

    /**
     * id : 100038
     * type : 2
     * publishtime : 636100128000000000
     * title : 秋水
     * summary : 车如流水马如龙，往事如春风 。

     感性的人向往爱情，可是真正的爱情对于感情细腻的人很难找，不爱的人即使再爱你，也丝毫感觉不到爱情，你爱的人辜负你，更痛心
     * image :
     */

    private List<ResultBean> result;

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

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
