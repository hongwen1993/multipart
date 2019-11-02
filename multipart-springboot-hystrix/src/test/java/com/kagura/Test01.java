package com.kagura;

import org.junit.Test;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.observables.SyncOnSubscribe;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/10/10 17:37
 * @since 1.0.0
 */
public class Test01 {

    @Test
    public void test01() throws InterruptedException {
        Observable<String> observable = Observable.create(new SyncOnSubscribe<Object, String>() {
            @Override
            protected Object generateState() {
                return null;
            }

            @Override
            protected Object next(Object state, Observer<? super String> observer) {
                observer.onNext("aaa");
                //observer.onNext("bbb");
                observer.onCompleted();
                return "123456";
            }
        });

        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.err.println("onCompleted ");
            }

            @Override
            public void onError(Throwable e) {
                System.err.println("onError " + e.getMessage());
            }

            @Override
            public void onNext(String s) {
                System.err.println("onNext : " + s);
            }
        };

        observable.subscribe(subscriber);


        //Thread.sleep(100000);


    }
}
