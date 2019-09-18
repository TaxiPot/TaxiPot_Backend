package kr.hs.dsm.java.taxipot_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "ACCOUNT NOT FOUND")
public class SignInNotExistException extends RuntimeException {
    public SignInNotExistException(String message) {
        super(message);
    }
}
