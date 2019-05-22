package com.jsedano.reactive.homework01;

import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.reactivex.Observable;

public class Main {



    public static void main(String []args) throws Exception {

        InputStream is = Main.class.getResourceAsStream("/news.json");

        NewsItemSubscribersCollection subscribersCollection = new NewsItemSubscribersCollection();



        List<NewsItem> li = new ObjectMapper().readValue(is, new TypeReference<List<NewsItem>>(){});


        Observable<NewsItem> observable = Observable.fromIterable(li);


        observable.safeSubscribe(subscribersCollection.getSportsObserver());
        observable.safeSubscribe(subscribersCollection.getShowBusinessObserver());
        observable.safeSubscribe(subscribersCollection.getShowBusinessAndSportObserver());
        observable.safeSubscribe(subscribersCollection.getPoliticsObserver());
        observable.safeSubscribe(subscribersCollection.getSportsShowBusinessAndPoliticsObserver());


    }
}
