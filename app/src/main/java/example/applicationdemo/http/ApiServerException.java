package example.applicationdemo.http;

/**
 * Created by cai.jia on 2017/9/25 0025
 */

public class ApiServerException extends RuntimeException {
    private int mCode = 0;

    private int mStatus = 1;

    private String mMessage = "";

    public ApiServerException(int code, int status, String message) {
        super(message);
        this.mCode = code;
        this.mStatus = status;
        this.mMessage = message;
    }

    public int getStatus() {
        return mStatus;
    }

    public int getCode() {
        return mCode;
    }

    @Override
    public String getMessage() {
        return mMessage;
    }
}
