package ltr.org.questionlist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ControllerAdvice
public class SystemException extends ResponseEntityExceptionHandler {
    ErrorDetails error=null;
    @ExceptionHandler({UserValidationException.class})
    public ResponseEntity<ErrorDetails> userValidationException(UserValidationException userValidationException) {
        this.error = new ErrorDetails(400, this.convertToList(userValidationException.getMsg()));
        return new ResponseEntity(this.error, HttpStatus.BAD_REQUEST);
    }

    protected List<String> convertToList(String message) {
        return Stream.of(message.split("\\|")).collect(Collectors.toList());
    }
}
