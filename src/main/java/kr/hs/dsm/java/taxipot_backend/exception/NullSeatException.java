package kr.hs.dsm.java.taxipot_backend.exception;

public class NullSeatException extends Exception {
    public NullSeatException() {
    }

    public NullSeatException(String message) {
        super(message);
    }
}
