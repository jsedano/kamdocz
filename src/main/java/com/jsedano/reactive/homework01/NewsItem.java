package com.jsedano.reactive.homework01;

public class NewsItem {

    enum NewsType {
        SPORTS, SHOW_BUSINESS, POLITICS;
    }
    
    private String id;
    private String content;
    private NewsType type;
    
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public NewsType getType() {
        return type;
    }
    public void setType(NewsType type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return "NewsItem [type=" + type + ", id=" + id + ", content=" + content + "]";
    }

    
    
    
    
    
   
}
