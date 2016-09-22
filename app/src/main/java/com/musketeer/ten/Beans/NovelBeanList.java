package com.musketeer.ten.Beans;

import android.os.Parcel;
import android.os.Parcelable;

import com.musketeer.ten.http.BeansNormalParser;

import org.xutils.http.annotation.HttpResponse;

import java.util.List;

/**
 * Created by Kevin on 2016/9/21.
 */
@HttpResponse(parser = BeansNormalParser.class)
public class NovelBeanList implements Parcelable{

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

    protected NovelBeanList(Parcel in) {
        result = in.createTypedArrayList(ResultBean.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(result);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<NovelBeanList> CREATOR = new Creator<NovelBeanList>() {
        @Override
        public NovelBeanList createFromParcel(Parcel in) {
            return new NovelBeanList(in);
        }

        @Override
        public NovelBeanList[] newArray(int size) {
            return new NovelBeanList[size];
        }
    };

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }




    public static class ResultBean implements Parcelable{
        private int id;
        private int type;
        private long publishtime;
        private String image;

        protected ResultBean(Parcel in) {
            id = in.readInt();
            type = in.readInt();
            publishtime = in.readLong();
            image = in.readString();
        }

        public static final Creator<ResultBean> CREATOR = new Creator<ResultBean>() {
            @Override
            public ResultBean createFromParcel(Parcel in) {
                return new ResultBean(in);
            }

            @Override
            public ResultBean[] newArray(int size) {
                return new ResultBean[size];
            }
        };

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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
            dest.writeInt(type);
            dest.writeLong(publishtime);
            dest.writeString(image);
        }
    }
}
