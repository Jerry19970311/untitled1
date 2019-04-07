import bean.NewsItem;

import java.util.Set;

public interface TagsUpdateable {
    void update(int id, Set<String> tags);
    void update(int id, NewsItem newsItem);
}
