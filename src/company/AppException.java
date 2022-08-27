package src.company;

/**
 * @author yudong
 * 受检异常(需要处理)
 */
public class AppException extends Exception {
    public AppException() {
        super();
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(String message) {
        super(message);
    }

    public AppException(Throwable cause) {
        super(cause);
    }
}
