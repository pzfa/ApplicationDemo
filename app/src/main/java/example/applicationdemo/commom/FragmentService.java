package example.applicationdemo.commom;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;

import java.util.List;

/**
 * 管理Fragment的显示和隐藏
 * Created by cai.jia on 2015/7/29.
 */
public class FragmentService {

    private FragmentManager manager;

    private int mEnter, mExit;

    public FragmentService(FragmentManager manager) {
        this.manager = manager;
    }

    public FragmentService setCustomAnimations(int enter, int exit) {
        this.mEnter = enter;
        this.mExit = exit;
        return this;
    }

    public void add(int containerViewId, Fragment f, boolean addToBackStack) {
        addOrShow(containerViewId, f, addToBackStack, null, false,false);
    }

    public void add(int containerViewId, Fragment f, boolean addToBackStack, boolean asyncCommit) {
        addOrShow(containerViewId, f, addToBackStack, null, false,asyncCommit);
    }

    public void addOrShow(int containerViewId, Fragment f,
                          boolean addToBackStack, String tag) {
        addOrShow(containerViewId, f, addToBackStack, tag, true,false);
    }

    public void addOrShow(int containerViewId, Fragment f,
                          boolean addToBackStack, String tag,boolean asyncCommit) {
        addOrShow(containerViewId, f, addToBackStack, tag, true,asyncCommit);
    }

    public void addOrShow(int containerViewId, Fragment f, boolean addToBackStack,
                          String tag, boolean hideOther, boolean asyncCommit) {
        if (manager == null || f == null) {
            return;
        }
        if (hideOther) {
            hideAll();
        }
        Fragment oldFm = findOldFragment(containerViewId, f.getClass(), tag);
        if (oldFm != null) {
            show(oldFm);
        } else {
            add(containerViewId, f, addToBackStack, tag,asyncCommit);
        }
    }

    public Fragment findOldFragment(int containerViewId, Class<? extends Fragment> clazz, String tag) {
        String realTag = uniqueTag(containerViewId, clazz, tag);
        return manager.findFragmentByTag(realTag);
    }

    public void add(int containerViewId, Fragment f, boolean addToBackStack, String tag, boolean asyncCommit) {
        if (f != null && !f.isAdded()) {
            FragmentTransaction transaction = getFragmentTransaction();
            String uniqueTag = uniqueTag(containerViewId, f.getClass(), tag);
            if (addToBackStack) {
                transaction.addToBackStack(tag);
            }
            transaction.add(containerViewId, f, uniqueTag).commit();
            if (asyncCommit) {
                manager.executePendingTransactions();
            }
        }
    }

    private FragmentTransaction getFragmentTransaction() {
        return manager.beginTransaction().setCustomAnimations(mEnter, mExit);
    }

    public void replace(int id,Fragment fragment) {
        getFragmentTransaction().replace(id, fragment).commit();
    }

    public void remove(Fragment f) {
        if (f != null) {
            FragmentTransaction transaction = getFragmentTransaction();
            transaction.remove(f).commit();
        }
    }

    public void show(Fragment f) {
        if (f != null) {
            FragmentTransaction transaction = getFragmentTransaction();
            transaction.show(f).commit();
        }
    }

    public void hide(Fragment f) {
        if (f != null) {
            FragmentTransaction transaction = getFragmentTransaction();
            transaction.hide(f).commit();
        }
    }

    public void hideAll() {
        List<Fragment> fragments = manager.getFragments();
        if (fragments != null && !fragments.isEmpty()) {
            for (Fragment f : fragments) {
                hide(f);
            }
        }
    }

    /**
     * 每个容器里面对应的唯一tag
     *
     * @param containerViewId 容器id
     * @param clazz           页面
     * @param tag             传进来的tag
     * @return
     */
    private String uniqueTag(int containerViewId, Class<? extends Fragment> clazz, String tag) {
        return containerViewId + clazz.getName() + (TextUtils.isEmpty(tag) ? "" : tag);
    }
}
