package example.applicationdemo.tinker;

/**
 * Created by cai.jia on 2017/10/18 0018
 */

public class BugClass {
    public String bug() {
        // 这段代码会报空指针异常
//        String str = null;
//        Log.e("BugClass", "get string length:" + str.length());
        return "This is a fixed bug class， xiaowu is very good";
    }
}
