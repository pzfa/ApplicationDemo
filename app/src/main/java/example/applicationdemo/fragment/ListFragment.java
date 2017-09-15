package example.applicationdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import example.applicationdemo.R;
import example.applicationdemo.commom.FragmentService;
import example.applicationdemo.controller.ListFragmentController;
import example.applicationdemo.glide.GlideExample;
import example.applicationdemo.glide.GlideListFragment;
import example.applicationdemo.retrofit.RetrofitFragment;
import example.applicationdemo.view.ListFragmentView;

/**
 * Created by cai.jia on 2017/9/14 0014
 */

public class ListFragment extends Fragment implements View.OnClickListener {
    public final static String TYPE = "type";
    ListFragmentView listFragmentView;
    ListFragmentController listFregmentController;
    ArrayList<Fragment> arrayList = new ArrayList<>();
    FragmentService fragmentService;
    int type;
    ViewTag viewTag;

    public void setViewTag(ViewTag viewTag) {
        this.viewTag = viewTag;
    }

    public ArrayList<Fragment> getArrayList() {
        return arrayList;
    }

    public   interface ViewTag{
        public void tagInt(int inden);
    }

    public static ListFragment getListFragment(int type) {
        ListFragment listFragment = new ListFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(TYPE, type);
        return listFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fregment_list, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fragmentService = new FragmentService(getChildFragmentManager());
        arrayList.clear();
        Bundle arguments = getArguments();
        if (arguments != null) {
            type = arguments.getInt(TYPE);
        }
        switch (type){
            case 0:
                arrayList.add(new GlideListFragment());
                arrayList.add(new GlideExample());
                arrayList.add(new RetrofitFragment());
                break;
        }
        listFragmentView = (ListFragmentView) getView().findViewById(R.id.List_fregment);
        listFragmentView.initView();
        listFregmentController = new ListFragmentController(listFragmentView, getActivity(),this);
        listFregmentController.initController();
        listFregmentController.setData(arrayList);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.item_list_fregment_tv:
                Log.d("aaaa",v.getTag()+">>>>");
                viewTag.tagInt((Integer) v.getTag());
                break;
        }

    }
}
