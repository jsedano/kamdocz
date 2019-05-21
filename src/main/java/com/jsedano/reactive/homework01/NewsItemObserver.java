package com.jsedano.reactive.homework01;

import java.util.function.BiConsumer;
import java.util.function.Predicate;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class NewsItemObserver implements Observer<NewsItem> {

    
    private Disposable disposable;
    
    private BiConsumer<String, NewsItem> onNextConsumer;
    
    private Predicate<NewsItem> unsubscribeCondition;
    
    private Predicate<NewsItem> consumeCondition;

    
    private String id;
    
    public NewsItemObserver(String id, BiConsumer<String, NewsItem> onNextConsumer,Predicate<NewsItem> consumeCondition, Predicate<NewsItem> unsubscribeCondition) {
        this.id = id;
        this.onNextConsumer = onNextConsumer;
        this.consumeCondition = consumeCondition;
        this.unsubscribeCondition = unsubscribeCondition;
    }
    
    
    @Override
    public void onComplete() {
        disposable.dispose();
    }

    @Override
    public void onError(Throwable arg0) {
        // NOOP
        
    }

    @Override
    public void onNext(NewsItem newsItem) {
        if(unsubscribeCondition.test(newsItem)){
            disposable.dispose();
        } else if (consumeCondition.test(newsItem)){
            onNextConsumer.accept(id, newsItem);
        }
    }

    @Override
    public void onSubscribe(Disposable disposable) {
        this.disposable = disposable;
    }

 

}
