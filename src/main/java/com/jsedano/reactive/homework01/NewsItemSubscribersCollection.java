package com.jsedano.reactive.homework01;

import java.util.function.BiConsumer;

public class NewsItemSubscribersCollection {
    
    

    
    private NewsItemObserver sportsObserver;
    
    private NewsItemObserver showBusinessObserver;

    private NewsItemObserver showBusinessAndSportObserver;

    private NewsItemObserver politicsObserver;
    
    private NewsItemObserver sportsShowBusinessAndPoliticsObserver;
    
    public NewsItemSubscribersCollection() {

        BiConsumer<String, NewsItem> biconsumer = (s,i) -> System.out.println("["+s+"] "+i);
        
        sportsObserver = new NewsItemObserver("SportsObserver", biconsumer, i -> i.getType() == NewsItem.NewsType.SPORTS, i -> false);
 
        showBusinessObserver = new NewsItemObserver("ShowBusinessObserver", biconsumer, i -> i.getType() == NewsItem.NewsType.SHOW_BUSINESS, i -> false);

        showBusinessAndSportObserver = new NewsItemObserver("ShowBusinessAndSportObserver", biconsumer, i -> {
            switch(i.getType()) {
            case SHOW_BUSINESS:
            case SPORTS:
                return true;
            default:
                return false;
            }
        }, i -> false);

        politicsObserver = new NewsItemObserver("PoliticsObserver", biconsumer, i -> i.getType() == NewsItem.NewsType.POLITICS, i -> i.getType() == NewsItem.NewsType.SHOW_BUSINESS);

        sportsShowBusinessAndPoliticsObserver = new NewsItemObserver("SportsShowBusinessAndPoliticsObserver", biconsumer, i -> true, i -> false);
    
    }
    
    
    public NewsItemObserver getSportsObserver() {
        return sportsObserver;
    }
    
    public NewsItemObserver getShowBusinessObserver() {
        return showBusinessObserver;
    }
    
    public NewsItemObserver getShowBusinessAndSportObserver() {
        return showBusinessAndSportObserver;
    }
    
    public NewsItemObserver getPoliticsObserver() {
        return politicsObserver;
    }
    
    public NewsItemObserver getSportsShowBusinessAndPoliticsObserver() {
        return sportsShowBusinessAndPoliticsObserver;
    }
}
