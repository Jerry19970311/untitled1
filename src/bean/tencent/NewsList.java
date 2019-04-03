package bean.tencent;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsList {
    /**
     * biz : 17002
     * code : 0
     * data : [{"article_type":23,"comment_id":"3746152932","comment_num":1181,"id":"20190227000640","irs_imgs":{"294X195":["http://inews.gtimg.com/newsapp_ls/0/7890223495_294195/0"]},"publish_time":"2019-02-27 14:30:41","source":"腾讯体育","source_id":"","tag_label":[["单杠","182333"],["徐嘉余","90454"],["潘晓婷","93448"]],"title":"谁的责任？健身大爷单杠练大回环撞飞小女孩","url":"https://new.qq.com/cmsn/20190227/SPO2019022700064000"},{"article_type":11,"comment_id":"3747987780","comment_num":535,"id":"20180805003682","irs_imgs":{"294X195":["http://inews.gtimg.com/newsapp_ls/0/7895033229_294195/0"]},"publish_time":"2019-02-27 14:13:33","source":"腾讯体育","source_id":"nba","tag_label":[],"title":"约基奇36+9+10韦少22+14+9 掘金擒雷霆取五连胜","url":"https://new.qq.com/zt/template/?id=NBA2018080500368200"},{"article_type":0,"comment_id":"3747918974","comment_num":2,"id":"20190227005873","irs_imgs":{"294X195":["http://inews.gtimg.com/newsapp_ls/0/7894627383_294195/0"]},"publish_time":"2019-02-27 13:39:16","source":"腾讯体育","source_id":"news_news_sports","tag_label":[["中超","81366"],["重庆斯威","10276485"],["广州富力","257708"]],"title":"重庆斯威发布新赛季首场战富力海报：\u201c引爆\u201d中超","url":"http://new.qq.com/cmsn/20190227/20190227005873.html"},{"article_type":23,"comment_id":"3747906366","comment_num":13,"id":"20190227005861","irs_imgs":{"294X195":["http://inews.gtimg.com/newsapp_ls/0/7895390565_294195/0"]},"publish_time":"2019-02-27 13:38:24","source":"腾讯体育","source_id":"","tag_label":[["乔治","87402"],["NBA","82542"]],"title":"要进就进这种球 乔治后场三分灯亮球进","url":"https://new.qq.com/cmsn/20190227/NBA2019022700586100"},{"article_type":23,"comment_id":"3747873549","comment_num":93,"id":"20190227005547","irs_imgs":{"294X195":["http://inews.gtimg.com/newsapp_ls/0/7895375526_294195/0"]},"publish_time":"2019-02-27 13:30:48","source":"腾讯体育","source_id":"","tag_label":[["威少","180408"],["约基奇","268363"],["NBA","82542"]],"title":"锁定五大囧了！韦少挑进乌龙球与约基奇合打一个2+1","url":"https://new.qq.com/cmsn/20190227/NBA2019022700554700"}]
     * msg : ok
     * seq : 20190227154155-Ed7FRqeuROULFtcj
     */

    private int biz;
    private int code;
    private String msg;
    private String seq;
    private List<DataBean> data;

    public int getBiz() {
        return biz;
    }

    public void setBiz(int biz) {
        this.biz = biz;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * article_type : 23
         * comment_id : 3746152932
         * comment_num : 1181
         * id : 20190227000640
         * irs_imgs : {"294X195":["http://inews.gtimg.com/newsapp_ls/0/7890223495_294195/0"]}
         * publish_time : 2019-02-27 14:30:41
         * source : 腾讯体育
         * source_id :
         * tag_label : [["单杠","182333"],["徐嘉余","90454"],["潘晓婷","93448"]]
         * title : 谁的责任？健身大爷单杠练大回环撞飞小女孩
         * url : https://new.qq.com/cmsn/20190227/SPO2019022700064000
         */

        private int article_type;
        private String comment_id;
        private int comment_num;
        private String id;
        private IrsImgsBean irs_imgs;
        private String publish_time;
        private String source;
        private String source_id;
        private String title;
        private String url;
        private List<List<String>> tag_label;

        public int getArticle_type() {
            return article_type;
        }

        public void setArticle_type(int article_type) {
            this.article_type = article_type;
        }

        public String getComment_id() {
            return comment_id;
        }

        public void setComment_id(String comment_id) {
            this.comment_id = comment_id;
        }

        public int getComment_num() {
            return comment_num;
        }

        public void setComment_num(int comment_num) {
            this.comment_num = comment_num;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public IrsImgsBean getIrs_imgs() {
            return irs_imgs;
        }

        public void setIrs_imgs(IrsImgsBean irs_imgs) {
            this.irs_imgs = irs_imgs;
        }

        public String getPublish_time() {
            return publish_time;
        }

        public void setPublish_time(String publish_time) {
            this.publish_time = publish_time;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getSource_id() {
            return source_id;
        }

        public void setSource_id(String source_id) {
            this.source_id = source_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<List<String>> getTag_label() {
            return tag_label;
        }

        public void setTag_label(List<List<String>> tag_label) {
            this.tag_label = tag_label;
        }

        public static class IrsImgsBean {
            @SerializedName("294X195")
            private List<String> _$294X195;

            public List<String> get_$294X195() {
                return _$294X195;
            }

            public void set_$294X195(List<String> _$294X195) {
                this._$294X195 = _$294X195;
            }
        }
    }
}
