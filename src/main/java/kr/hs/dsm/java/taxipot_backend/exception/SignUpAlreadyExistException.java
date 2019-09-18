package kr.hs.dsm.java.taxipot_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Account Already Exist")
public class SignUpAlreadyExistException extends RuntimeException {
    public SignUpAlreadyExistException(String message) {
        super(message);
    }
}
