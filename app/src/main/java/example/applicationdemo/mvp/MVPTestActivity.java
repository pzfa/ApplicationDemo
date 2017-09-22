package example.applicationdemo.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import example.applicationdemo.R;

/**
 * Created by cai.jia on 2017/9/21 0021
 */

public class MVPTestActivity extends Fragment implements MVPTestContract.View {


    MVPPresenter mvpPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.act_mvptest,container,false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mvpPresenter = new MVPPresenter(this);
        getView().findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mvpPresenter.logn("111","111");
            }
        });
    }




    @Override
    public void onLoginOK(boolean state) {
        Toast.makeText(getActivity(),"登录状态》》》"+state,Toast.LENGTH_SHORT).show();
    }
}
