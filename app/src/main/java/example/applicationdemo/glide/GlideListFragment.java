package example.applicationdemo.glide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import example.applicationdemo.R;
import example.applicationdemo.controller.GlideListController;
import example.applicationdemo.view.GlideListView;

/**
 * Created by cai.jia on 2017/9/13 0013
 */

public class GlideListFragment extends Fragment {

    GlideListController glideListController;
    public  String[] eatFoodyImages = {
            "http://www.123rf.com.cn/public/images/interview/v4/3_9.jpg",
            "http://www.123rf.com.cn/public/images/interview/v4/3_14.jpg",
            "http://t1.mmonly.cc/uploads/allimg/20150610/b5a117aee42d96e525ba333931306df0.jpg",
            "http://t1.mmonly.cc/uploads/tu/201703/33/131.jpg",
            "http://t1.mmonly.cc/uploads/tu/201609/73/64bOOOPIC7a_1024.jpg",
            "http://t1.mmonly.cc/uploads/tu/201609/73/12106414_120840139056_2.jpg",
            "http://t1.mmonly.cc/uploads/tu/201609/73/20394056_154533817000_2.jpg",
            "http://t1.mmonly.cc/uploads/tu/201601/151/aspdfpivur3.jpg",
            "http://t1.mmonly.cc/uploads/tu/201601/151/4hnhqhoixcz.jpg",
            "http://t1.mmonly.cc/uploads/tu/201601/151/gcxinfa11jr.jpg",
            "http://t1.mmonly.cc/uploads/tu/201601/151/qpuodbt0dkg.jpg",
            "http://www.123rf.com.cn/public/images/interview/v4/1_2.jpg",
            "http://www.123rf.com.cn/public/images/interview/v4/3_7.jpg",
            "http://www.123rf.com.cn/public/images/interview/v4/3_12.jpg",
    };

    String internetUrl = "http://imgsrc.baidu.com/image/c0%3Dshijue1%2C0%2C0%2C294%2C40/sign=3d2175db3cd3d539d530078052ee8325/b7003af33a87e950c1e1a6491a385343fbf2b425.jpg" ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_glide_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<String> iamge= new ArrayList<>();
        iamge.clear();
        for(int i =0;i<eatFoodyImages.length;i++){
//            iamge.add(internetUrl);
            iamge.add(eatFoodyImages[i]);
        }
        GlideListView glideListView = (GlideListView) getView().findViewById(R.id.glide_list_view);
        glideListView.initView();
        glideListController = new GlideListController(getActivity(),glideListView);
        glideListController.initController();
        glideListController.setImageList(iamge);
    }
}
