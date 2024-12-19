package ltr.org.questionlist.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MasterResponseBean extends BaseBean implements Serializable {
    private Long masterId;
    private String mimCode;
    private String mimCodeValue;
    private String mimCodeValueDesc;
    private String isDeleted;
}