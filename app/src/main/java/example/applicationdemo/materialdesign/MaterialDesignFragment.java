package example.applicationdemo.materialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.applicationdemo.R;

/**
 * Created by cai.jia on 2017/10/9 0009
 */

public class MaterialDesignFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_materal_design, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().findViewById(R.id.AppBarLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              getActivity().startActivity(new Intent(getActivity(),AppBarLayoutActivity.class));
            }
        });
        getView().findViewById(R.id.CollapsingToolbarActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(),CollapsingToolbarActivity.class));
            }
        });
    }
}
