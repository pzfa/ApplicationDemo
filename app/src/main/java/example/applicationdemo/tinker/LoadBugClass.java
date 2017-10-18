package example.applicationdemo.tinker;

/**
 * Created by cai.jia on 2017/10/18 0018
 */

public class LoadBugClass {
    /**
     * 获取bug字符串.
     *
     * @return 返回bug字符串
     */
    public static String getBugString() {
        BugClass bugClass = new BugClass();
        return bugClass.bug();
    }
}
