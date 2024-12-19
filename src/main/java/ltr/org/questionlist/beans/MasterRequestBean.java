package ltr.org.questionlist.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterRequestBean extends BaseBean implements Serializable {
    private Long masterId;
    @NotBlank(message = "Mim Code can not be blank")
    private String mimCode;
    @NotBlank(message = "Mim Code Value can not be blank")
    private String mimCodeValue;
    @NotBlank(message = "Mim Code Value Description can not be blank")
    private String mimCodeValueDesc;
}
