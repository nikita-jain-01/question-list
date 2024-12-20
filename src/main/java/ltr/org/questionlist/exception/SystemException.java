package ltr.org.questionlist.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public abstract class SystemException extends ResponseEntityExceptionHandler {
    ErrorDetails error = null;
    @Value("${lms.custom.exception.handleNullPointerException}")
    private String handleNullPointerException;
    @Value("${lms.custom.exception.DataNotFoundException}")
    private String dataNotFoundException;
    @Value("${lms.custom.exception.PatternSyntaxException}")
    private String patternSyntaxException;
    @Value("${lms.custom.exception.JpaSystemException}")
    private String jpaSystemException;
    @Value("${lms.custom.exception.UnsupportedMediaType}")
    private String unsupportedMediaType;
    @Value("${lms.custom.exception.InvalidDataAccessResourceUsageException}")
    private String invalidDataAccessResourceUsageException;
    @Value("${lms.custom.exception.InvalidDataAccessApiUsageException}")
    private String invalidDataAccessApiUsageException;
    @Value("${lms.custom.exception.DataAccessResourceFailureException}")
    private String dataAccessResourceFailureException;
    @Value("${lms.custom.exception.GatewayTimeout}")
    private String gatewayTimeout;
    @Value("${lms.custom.exception.NotImplemented}")
    private String notImplemented;
    @Value("${lms.custom.exception.DataIntegrityViolationException}")
    private String dataIntegrityViolationException;
    @Value("${lms.custom.exception.HttpMediaTypeNotSupported}")
    private String httpMediaTypeNotSupported;
    @Value("${lms.custom.exception.HttpRequestMethodNotSupported}")
    private String httpRequestMethodNotSupported;
    @Value("${lms.custom.exception.MissingPathVariable}")
    private String missingPathVariable;
    @Value("${lms.custom.exception.HttpMediaTypeNotAcceptable}")
    private String httpMediaTypeNotAcceptable;
    @Value("${lms.custom.exception.httpMessageNotReadable}")
    private String httpMessageNotReadable;
    @Value("${lms.custom.exception.missingServletRequestParameter}")
    private String missingServletRequestParameter;

    public SystemException() {
    }

    @ExceptionHandler({DataNotFoundException.class})
    public ResponseEntity<ErrorDetails> handleNoDataFoundException(DataNotFoundException exception) {
        this.error = new ErrorDetails(404, this.convertToList(exception.getMsg()));
        this.logger.error("Exception from common config: ", exception);
        return new ResponseEntity(this.error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorDetails> handleGenericException(Exception exception) {
        this.error = new ErrorDetails(400, this.convertToList(exception.getMessage()));
        this.logger.error("Exception from common config: ", exception);
        return new ResponseEntity(this.error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({UserValidationException.class})
    public ResponseEntity<ErrorDetails> userValidationException(UserValidationException userValidationException) {
        this.error = new ErrorDetails(400, this.convertToList(userValidationException.getMsg()));
        return new ResponseEntity(this.error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({PatternSyntaxException.class})
    public ResponseEntity<ErrorDetails> handlePatternSyntaxException(Exception exception) {
        this.error = new ErrorDetails(400, this.convertToList(this.patternSyntaxException));
        this.logger.error("Exception from common config: ", exception);
        return new ResponseEntity(this.error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({JpaSystemException.class})
    public ResponseEntity<ErrorDetails> handleJpaSystemException(Exception exception) {
        this.error = new ErrorDetails(400, this.convertToList(this.jpaSystemException));
        this.logger.error("Exception from common config: ", exception);
        return new ResponseEntity(this.error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<ErrorDetails> handleNullPointerException(Exception exception) {
        this.error = new ErrorDetails(500, this.convertToList(this.handleNullPointerException));
        this.logger.error("Exception from common config: ", exception);
        return new ResponseEntity(this.error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({HttpClientErrorException.UnsupportedMediaType.class})
    public ResponseEntity<ErrorDetails> handleUnsupportedMediaType(Exception exception) {
        this.error = new ErrorDetails(500, this.convertToList(this.unsupportedMediaType));
        this.logger.error("Exception from common config: ", exception);
        return new ResponseEntity(this.error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({InvalidDataAccessResourceUsageException.class})
    public ResponseEntity<ErrorDetails> handleInvalidDataAccessResourceUsageException(Exception exception) {
        this.error = new ErrorDetails(400, this.convertToList(this.invalidDataAccessResourceUsageException));
        this.logger.error("Exception from common config: ", exception);
        return new ResponseEntity(this.error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({InvalidDataAccessApiUsageException.class})
    public ResponseEntity<ErrorDetails> handleInvalidDataAccessApiUsageException(Exception exception) {
        this.error = new ErrorDetails(400, this.convertToList(this.invalidDataAccessApiUsageException));
        this.logger.error("Exception from common config: ", exception);
        return new ResponseEntity(this.error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({DataAccessResourceFailureException.class})
    public ResponseEntity<ErrorDetails> handleDataAccessResourceFailureException(Exception exception) {
        this.error = new ErrorDetails(400, this.convertToList(this.dataAccessResourceFailureException));
        this.logger.error("Exception from common config: ", exception);
        return new ResponseEntity(this.error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({HttpServerErrorException.GatewayTimeout.class})
    public ResponseEntity<ErrorDetails> handleGatewayTimeout(Exception exception) {
        this.error = new ErrorDetails(504, this.convertToList(this.gatewayTimeout));
        this.logger.error("Exception from common config: ", exception);
        return new ResponseEntity(this.error, HttpStatus.GATEWAY_TIMEOUT);
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<ErrorDetails> handleDataIntegrityViolationException(Exception exception) {
        this.error = new ErrorDetails(400, this.convertToList(this.dataIntegrityViolationException));
        this.logger.error("Exception from common config: ", exception);
        return new ResponseEntity(this.error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({HttpServerErrorException.NotImplemented.class})
    public ResponseEntity<ErrorDetails> handleNotImplemented(Exception exception) {
        this.error = new ErrorDetails(501, this.convertToList(this.notImplemented));
        this.logger.error("Exception from common config: ", exception);
        return new ResponseEntity(this.error, HttpStatus.NOT_IMPLEMENTED);
    }

    @ExceptionHandler({MissingRequestHeaderException.class})
    public ResponseEntity<ErrorDetails> handleRequestHeader(MissingRequestHeaderException ex) {
        this.error = new ErrorDetails(HttpStatus.BAD_REQUEST.value(), this.convertToList(ex.getMessage()));
        this.logger.error("Exception from common config: ", ex);
        return new ResponseEntity(this.error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({HttpClientErrorException.class})
    public final ResponseEntity<Object> callBackException(HttpClientErrorException ex, WebRequest request) throws JsonProcessingException {
        this.logger.error(ex.getMessage());
        HttpStatus httpStatus = (HttpStatus) ex.getStatusCode();
        String message = ex.getResponseBodyAsString();
        LinkedHashMap errorResponse = (LinkedHashMap)(new ObjectMapper()).readValue(message, LinkedHashMap.class);
        return new ResponseEntity(errorResponse, httpStatus);
    }

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap();
        body.put("status", status.value());
        List<String> errors = (List)ex.getBindingResult().getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
        body.put("message", errors);
        this.logger.error("Exception from common config: ", ex);
        return new ResponseEntity(body, status);
    }

    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());
        body.put("message", this.convertToList(this.httpMediaTypeNotSupported));
        this.logger.error("Exception from common config: ", ex);
        return new ResponseEntity(body, status);
    }

    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap();
        body.put("status", status.value());
        body.put("message", this.convertToList(this.httpRequestMethodNotSupported));
        this.logger.error("Exception from common config: ", ex);
        return new ResponseEntity(body, status);
    }

    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap();
        body.put("status", status.value());
        body.put("message", this.convertToList(this.missingPathVariable));
        this.logger.error("Exception from common config: ", ex);
        return new ResponseEntity(body, status);
    }

    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap();
        body.put("status", status.value());
        body.put("message", this.convertToList(this.httpMediaTypeNotAcceptable));
        this.logger.error("Exception from common config: ", ex);
        return new ResponseEntity(body, status);
    }

    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap();
        body.put("status", status.value());
        body.put("message", this.convertToList(this.httpMessageNotReadable));
        this.logger.error("Exception from common config: ", ex);
        return new ResponseEntity(body, status);
    }

    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap();
        body.put("status", status.value());
        body.put("message", this.convertToList(this.missingServletRequestParameter));
        this.logger.error("Exception from common config: ", ex);
        return new ResponseEntity(body, status);
    }

    protected List<String> convertToList(String message) {
        return Stream.of(message.split("\\|")).collect(Collectors.toList());
    }
}
