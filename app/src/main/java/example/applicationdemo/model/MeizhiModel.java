package example.applicationdemo.model;

import java.util.List;

/**
 * Created by cai.jia on 2017/9/18 0018
 */

public class MeizhiModel {
    /**
     * _id : 59b7a98e421aa911847a0392
     * createdAt : 2017-09-12T17:31:58.794Z
     * desc : ViewStub学习
     * images : ["http://img.gank.io/9f51b7bc-73d3-4ce4-bd59-c61cb0c64325"]
     * publishedAt : 2017-09-14T16:36:51.63Z
     * source : web
     * type : Android
     * url : http://rkhcy.github.io/2017/09/12/ViewStub%E5%AD%A6%E4%B9%A0/
     * used : true
     * who : HuYounger
     */

    private String _id;
    private String createdAt;
    private String desc;
    private String publishedAt;
    private String source;
    private String type;
    private String url;
    private boolean used;
    private String who;
    private List<String> images;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
