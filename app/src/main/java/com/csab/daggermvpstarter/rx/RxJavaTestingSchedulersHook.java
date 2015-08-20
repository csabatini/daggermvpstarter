package com.csab.daggermvpstarter.rx;

import rx.Scheduler;
import rx.functions.Action0;
import rx.plugins.RxJavaSchedulersHook;
import rx.schedulers.Schedulers;

public class RxJavaTestingSchedulersHook extends RxJavaSchedulersHook {

    /**
    * Testing hook that will return the immediate instead of the IO scheduler
    */
    public RxJavaTestingSchedulersHook() {
        super();
    }

    @Override
    public Scheduler getComputationScheduler() {
        return super.getComputationScheduler();
    }

    @Override
    public Scheduler getIOScheduler() {
        return Schedulers.immediate();
    }

    @Override
    public Scheduler getNewThreadScheduler() {
        return super.getNewThreadScheduler();
    }

    @Override
    public Action0 onSchedule(Action0 action) {
        return super.onSchedule(action);
    }
}
