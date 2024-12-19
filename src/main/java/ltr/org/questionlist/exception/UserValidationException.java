package ltr.org.questionlist.exception;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserValidationException extends RuntimeException{

    private Integer status;
    private String msg;

    public UserValidationException(String msg) {
        this.msg=msg;
    }

}
