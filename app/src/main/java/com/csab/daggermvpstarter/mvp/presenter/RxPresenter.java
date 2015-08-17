package com.csab.daggermvpstarter.mvp.presenter;

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

}