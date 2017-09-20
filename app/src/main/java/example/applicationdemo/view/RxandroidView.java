package example.applicationdemo.view;

import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.widget.TextView;

import example.applicationdemo.R;

/**
 * Created by cai.jia on 2017/9/19 0019
 */

public class RxandroidView {
    NestedScrollView nestedScrollView;
    View.OnClickListener onClickListener;
    TextView test1, test_thread;


    public RxandroidView(NestedScrollView nestedScrollView) {
        this.nestedScrollView = nestedScrollView;

    }

    public void initView(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        test1 = (TextView) nestedScrollView.findViewById(R.id.test1);
        test_thread = (TextView) nestedScrollView.findViewById(R.id.test_thread);
        nestedScrollView.findViewById(R.id.test_thread2).setOnClickListener(onClickListener);
        nestedScrollView.findViewById(R.id.test_http).setOnClickListener(onClickListener);
        nestedScrollView.findViewById(R.id.test_map).setOnClickListener(onClickListener);
        nestedScrollView.findViewById(R.id.test_flatMap).setOnClickListener(onClickListener);
        test1.setOnClickListener(onClickListener);
        test_thread.setOnClickListener(onClickListener);
    }


}
