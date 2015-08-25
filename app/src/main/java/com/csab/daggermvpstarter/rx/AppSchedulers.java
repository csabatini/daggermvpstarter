package com.csab.daggermvpstarter.rx;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class AppSchedulers {

    private Scheduler subscribingSched;
    private Scheduler observingSched;

    private AppSchedulers(Scheduler subscribingSched, Scheduler observingSched) {
        this.subscribingSched = subscribingSched;
        this.observingSched = observingSched;
    }

    public static AppSchedulers newLiveInstance() {
        return new AppSchedulers(Schedulers.io(), AndroidSchedulers.mainThread());
    }

    public static AppSchedulers newTestInstance() {
        return new AppSchedulers(Schedulers.immediate(), Schedulers.immediate());
    }

    public Scheduler getObservingSched() {
        return observingSched;
    }

    public Scheduler getSubscribingSched() {
        return subscribingSched;
    }
}
