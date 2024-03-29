package kr.co.seoulit.account.sys.base.exception;

@SuppressWarnings("serial")
public class PwMissmatchException extends Exception {
    public PwMissmatchException(String msg) {
        super(msg);
    }
}
