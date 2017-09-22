package example.applicationdemo.mvp;

/**
 * Created by cai.jia on 2017/9/21 0021
 */

public class MVPPresenter implements MVPTestContract.Presenter {


    MVPTestContract.View view;

    public MVPPresenter(MVPTestContract.View view) {
        this.view = view;
    }



    @Override
    public void start() {

    }

    @Override
    public void logn(String name, String pass) {

        if(name.equals("111")&&pass.equals("111")){
            view.onLoginOK(true);
        }else {
            view.onLoginOK(false);

        }
    }
}
