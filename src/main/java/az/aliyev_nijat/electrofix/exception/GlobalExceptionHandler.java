package az.aliyev_nijat.electrofix.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GlobalExceptionModel> validation(
            MethodArgumentNotValidException ex
    ) {
        String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .reduce("", (a, b) -> b + "\n" + a);

        return ResponseEntity
                .unprocessableEntity()
                .body(new GlobalExceptionModel(message));
    }

    @ExceptionHandler(StatusNotExistException.class)
    public ResponseEntity<GlobalExceptionModel> validation(
            StatusNotExistException ex
    ) {
        return ResponseEntity
                .badRequest()
                .body(new GlobalExceptionModel(ex.getMessage()));
    }
}
