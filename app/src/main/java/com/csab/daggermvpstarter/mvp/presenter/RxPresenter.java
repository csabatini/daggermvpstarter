package com.csab.daggermvpstarter.mvp.presenter;

import com.csab.daggermvpstarter.rx.AppSchedulers;

import rx.Observable;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class RxPresenter {

    private final CompositeSubscription subscriptions = new CompositeSubscription();

    public void add(Subscription subscription) {
        subscriptions.add(subscription);
    }

    public void remove(Subscription subscription) {
        subscriptions.remove(subscription);
    }

    protected void unsubscribe() {
        subscriptions.unsubscribe();
    }

    protected <T> Observable.Transformer<T, T> applySchedulers(final AppSchedulers schedulers) {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
                return observable.subscribeOn(schedulers.getSubscribingSched())
                                 .observeOn(schedulers.getObservingSched());
            }
        };
    }

}