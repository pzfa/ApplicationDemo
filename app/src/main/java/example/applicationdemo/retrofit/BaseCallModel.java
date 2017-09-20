package example.applicationdemo.retrofit;

/**
 * Created by cai.jia on 2017/9/18 0018
 */

public class BaseCallModel<T> {
    public int errno;
    public String msg;
    private boolean error;
    public T data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
