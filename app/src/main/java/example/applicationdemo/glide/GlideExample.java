package example.applicationdemo.glide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.applicationdemo.R;
import example.applicationdemo.view.GlideView;

/**
 * Created by cai.jia on 2017/9/12 0012
 */

public class GlideExample extends Fragment implements View.OnClickListener {
    GlideView mGlideView;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_glide,container,false);
        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mGlideView = (GlideView) view.findViewById(R.id.glide_view);
        mGlideView.init(getActivity(),this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.go_glide:
                mGlideView.initGlide();
                break;
        }
    }
}
