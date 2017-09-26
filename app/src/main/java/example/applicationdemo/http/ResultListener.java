package example.applicationdemo.http;

/**
 * Created by cai.jia on 2017/9/20 0020
 */

public interface ResultListener<T> {

     void onResultBack(BaseCallModel<T> t);
}
