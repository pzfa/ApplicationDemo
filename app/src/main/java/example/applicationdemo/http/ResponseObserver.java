package example.applicationdemo.http;

import android.app.Activity;
import android.content.Context;

import example.applicationdemo.retrofit.ResultListener;
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
        BaseCallModel baseCallModel = new BaseCallModel();
        baseCallModel.setData(t);
        setResultData(baseCallModel);
    }


    @Override
    public void onError(Throwable error) {
        String message = error.getMessage();
        BaseCallModel baseCallModel = new BaseCallModel();
        baseCallModel.setErrno(message);
        setResultData(baseCallModel);


    }

    @Override
    public void onComplete() {

    }


    private void setResultData(BaseCallModel baseCallModel) {

        if(resultListener!=null){
            resultListener.onResultBack(baseCallModel);
        }
    }
}
