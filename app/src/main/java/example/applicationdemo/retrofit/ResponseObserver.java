package example.applicationdemo.retrofit;

import android.app.Activity;
import android.content.Context;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by cai.jia on 2017/9/20 0020
 */

public class ResponseObserver<T> implements Observer<T>{
    ResultListener resultListener;
    Context context;

    public ResponseObserver(ResultListener resultListener, Context context) {
        this.resultListener = resultListener;
        this.context = context;
    }

    @Override
    public void onSubscribe(Disposable d) {
        if(context instanceof Activity && ((Activity)context).isFinishing()){
            d.dispose();
        }

    }

    @Override
    public void onNext(T t) {
        BaseCallModel resultListener = new BaseCallModel();
        resultListener.setData(t);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
