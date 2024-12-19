package ltr.org.questionlist.beans;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseBean implements Serializable {
    @NotBlank(message = "Created By can not be Blank")
    private String createdBy;
    private LocalDateTime creationDateTime;
    private LocalDateTime updateDateTime;
    @NotBlank(message = "Is Deleted can not be Blank")
    private String isDeleted;
}
