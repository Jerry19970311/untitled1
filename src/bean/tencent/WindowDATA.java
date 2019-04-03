package bean.tencent;

import java.util.List;

public class WindowDATA {
    /**
     * article_id : 20190401A03WML
     * cms_id : 20190401A03WML00
     * article_type : 0
     * title : 4.1愚人节盘点：这些“精品谣言”，99％的人都中过招
     * tags : 尼克松;愚人节;谣言;ufo;西雅图,腾讯网,腾讯新闻
     * media : 较真
     * media_id : 5107513
     * update_time : 1554090221
     * pubtime : 2019-04-01 10:00:21
     * comment_id : 3817763587
     * political : 0
     * cms_site :
     * catalog1 : society
     * catalog2 : worldsociety
     * artTemplate : null
     * FztCompetition : null
     * FCompetitionName : null
     * videoArr : []
     */

    private String article_id;
    private String cms_id;
    private int article_type;
    private String title;
    private String tags;
    private String media;
    private String media_id;
    private int update_time;
    private String pubtime;
    private String comment_id;
    private int political;
    private String cms_site;
    private String catalog1;
    private String catalog2;
    private Object artTemplate;
    private Object FztCompetition;
    private Object FCompetitionName;
    private List<?> videoArr;

    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    public String getCms_id() {
        return cms_id;
    }

    public void setCms_id(String cms_id) {
        this.cms_id = cms_id;
    }

    public int getArticle_type() {
        return article_type;
    }

    public void setArticle_type(int article_type) {
        this.article_type = article_type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public int getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(int update_time) {
        this.update_time = update_time;
    }

    public String getPubtime() {
        return pubtime;
    }

    public void setPubtime(String pubtime) {
        this.pubtime = pubtime;
    }

    public String getComment_id() {
        return comment_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public int getPolitical() {
        return political;
    }

    public void setPolitical(int political) {
        this.political = political;
    }

    public String getCms_site() {
        return cms_site;
    }

    public void setCms_site(String cms_site) {
        this.cms_site = cms_site;
    }

    public String getCatalog1() {
        return catalog1;
    }

    public void setCatalog1(String catalog1) {
        this.catalog1 = catalog1;
    }

    public String getCatalog2() {
        return catalog2;
    }

    public void setCatalog2(String catalog2) {
        this.catalog2 = catalog2;
    }

    public Object getArtTemplate() {
        return artTemplate;
    }

    public void setArtTemplate(Object artTemplate) {
        this.artTemplate = artTemplate;
    }

    public Object getFztCompetition() {
        return FztCompetition;
    }

    public void setFztCompetition(Object FztCompetition) {
        this.FztCompetition = FztCompetition;
    }

    public Object getFCompetitionName() {
        return FCompetitionName;
    }

    public void setFCompetitionName(Object FCompetitionName) {
        this.FCompetitionName = FCompetitionName;
    }

    public List<?> getVideoArr() {
        return videoArr;
    }

    public void setVideoArr(List<?> videoArr) {
        this.videoArr = videoArr;
    }
}
