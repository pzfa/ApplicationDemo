package example.applicationdemo.controller;

import android.content.Context;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import example.applicationdemo.R;
import example.applicationdemo.view.RxandroidView;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by cai.jia on 2017/9/19 0019
 */

public class RxandroidController implements View.OnClickListener {
    RxandroidView rxandroidView;
    Context context;
    String TAG = "aaa";

    public RxandroidController(RxandroidView rxandroidView, Context context) {
        this.rxandroidView = rxandroidView;
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.test1:
                ObservableDemo();
//                throw new ApiException(100);
////                ObservableDemo1();
//                break;
            case R.id.test_thread:
                ThreadObservableDemo();
                break;
            case R.id.test_thread2:
                Thread2ObservableDemo();
                break;
            case R.id.test_http:
                HttpObservable();
                break;
            case R.id.test_map:
                ObservableMap();
                break;
            case R.id.test_flatMap:
                ObservableFlatMap();

                break;
        }

    }

    private void ObservableFlatMap() {
        //concatMap吧, 它和flatMap的作用几乎一模一样, 只是它的结果是严格按照上游发送的顺序来发送的
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
            }
        }).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(@NonNull Integer integer) throws Exception {
                ArrayList<String> arrayList = new ArrayList();
                for(int i = 0;i<3;i++){
                    arrayList.add("I am value " + i);
                }
                return Observable.fromIterable(arrayList).delay(10, TimeUnit.MILLISECONDS);

            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                Log.d(TAG, "onNext...."+s);

            }
        });
    }


    private void ObservableMap() {
        //map  中的函数作用是将圆形事件转换为矩形事件, 从而导致下游接收到的事件就变为了矩形.
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();

            }
        }).map(new Function<Integer, String>() {
            @Override
            public String apply(@NonNull Integer integer) throws Exception {
                return "this is result "+integer;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                Log.d(TAG, "onNext...."+s);
            }
        });
    }

    private void HttpObservable() {
//        Retrofit instance = RetrofitManager.getInstance("http://gank.io/");
//        RetrofitService retrofitService = instance.create(RetrofitService.class);
//        JSONObject jsonObject = new JSONObject();


//        ResponseObserver responseObserver = new ResponseObserver(context);
//        retrofitService.getAndroidDate()
//                .subscribe(responseObserver);



//        retrofitService
//                .getAndroidDate()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<ResponseBody>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "subscribe");
//                    }
//
//                    @Override
//                    public void onNext(ResponseBody responseBody) {
//                        try {
//                            Log.d(TAG, "onNext...."+responseBody.string());
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "onError");
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "onComplete");
//
//                    }
//                });

    }

    private void Thread2ObservableDemo() {
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.d(TAG, "Observable thread is : " + Thread.currentThread().getName());
                Log.d(TAG, "emit 1");
                emitter.onNext(1);
            }
        });

        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.d(TAG, "Observer thread is :" + Thread.currentThread().getName());
                Log.d(TAG, "onNext: " + integer);
            }
        };

        observable.subscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d(TAG, "After observeOn(mainThread), current thread is: " + Thread.currentThread().getName());
                    }
                })
                .observeOn(Schedulers.io())
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d(TAG, "After observeOn(io), current thread is : " + Thread.currentThread().getName());
                    }
                })
                .subscribe(consumer);

    }

    private void ThreadObservableDemo() {
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.d(TAG, "Observable thread is : " + Thread.currentThread().getName());
                Log.d(TAG, "emit 1");
                emitter.onNext(1);
            }
        });

        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.d(TAG, "Observer thread is :" + Thread.currentThread().getName());
                Log.d(TAG, "onNext: " + integer);
            }
        };

//        Schedulers.io();
//        Schedulers.newThread();
        observable.subscribeOn(Schedulers.newThread())//Observable 线程设置
                .observeOn(AndroidSchedulers.mainThread())//Observer 线程设置
                .subscribe(consumer);


    }

    private void ObservableDemo1() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(@NonNull Integer integer) throws Exception {
                Log.d(TAG, "" + integer);
            }
        });
    }

    private void ObservableDemo() {
        //创建一个上游 Observable：(可观察者)
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                //ObservableEmitter 发射动作
                emitter.onNext(1); // 执行发生变化的动作
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        });
        //创建一个下游 Observer（观察者）
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                //Disposable 下游开关
                // d.dispose(); 下游调用 关闭开关后就就接收不到上游数据onNext()
                Log.d(TAG, "subscribe");
            }

            @Override
            public void onNext(Integer value) {
                Log.d(TAG, "" + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "error");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "complete");
            }
        };
        //建立连接
        observable.subscribe(observer);
    }
}
