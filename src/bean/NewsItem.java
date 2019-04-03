package bean;

import java.util.HashSet;
import java.util.Set;

public class NewsItem {
    private int index;
    private String id;
    private String source;
    private String type;
    private String parent_author;
    private String topic;
    private String author;
    private long publish_time;
    private String url;
    private String text_path;
    private String comment_id;
    private Set<String> tags;
    public NewsItem(){
        tags=new HashSet<String>();
    }

    public String getSource() {
        return source;
    }

    public String getId() {
        return id;
    }

    public int getIndex() {
        return index;
    }

    public long getPublish_time() {
        return publish_time;
    }

    public String getAuthor() {
        return author;
    }

    public String getParent_author() {
        return parent_author;
    }

    public String getTopic() {
        return topic;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public String getText_path() {
        return text_path;
    }

    public String getComment_id() {
        return comment_id;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setPublish_time(long publish_time) {
        this.publish_time = publish_time;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setParent_author(String parent_author) {
        this.parent_author = parent_author;
    }

    public void setText_path(String text_path) {
        this.text_path = text_path;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }
}
