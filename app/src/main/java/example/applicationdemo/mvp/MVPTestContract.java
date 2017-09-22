package example.applicationdemo.mvp;

/**
 * Created by cai.jia on 2017/9/21 0021
 */

public interface MVPTestContract {

    interface  View extends BaseView{

        void onLoginOK(boolean state);
    }

    interface Presenter extends BasePresenter{


        void logn(String name,String pass);


    }
}
