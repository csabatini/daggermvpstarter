package com.csab.daggermvpstarter.rx;

import rx.Scheduler;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.functions.Action0;
import rx.schedulers.Schedulers;


public class RxAndroidTestingSchedulersHook extends RxAndroidSchedulersHook {

    /**
     * Testing hook that will return the immediate instead of the main thread scheduler
     */
    public RxAndroidTestingSchedulersHook() {
        super();
    }

    @Override
    public Scheduler getMainThreadScheduler() {
        return Schedulers.immediate();
    }

    @Override
    public Action0 onSchedule(Action0 action) {
        return super.onSchedule(action);
    }
}
