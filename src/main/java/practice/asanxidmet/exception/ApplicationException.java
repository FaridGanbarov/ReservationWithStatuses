package practice.asanxidmet.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import practice.asanxidmet.enums.Exceptions;

@Getter
public class ApplicationException extends RuntimeException {
    private final Exceptions exception;

    public ApplicationException(Exceptions exception) {
        super(exception.getMessage());
        this.exception = exception;
    }

    public HttpStatus getHttpStatus() {
        return exception.getHttpStatus();
    }
}
