package example.applicationdemo.retrofit;

/**
 * Created by cai.jia on 2017/9/18 0018
 */

public class BaseCallModel<T> {
    public int errno;
    public String msg;
    private boolean error;
    public T data;
}
