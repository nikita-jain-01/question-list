package ltr.org.questionlist.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="masters_m", schema="common_masters")
@ToString(callSuper = true)
@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class MastersEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "masters_m_seq")
    @SequenceGenerator(name = "masters_m_seq", sequenceName = "masters_m_seq", schema = "common_masters", allocationSize = 1)
    @Column(name="MASTER_ID")
    private Long masterId;
    @Column(name = "MIM_CODE")
    private String mimCode;
    @Column(name = "MIM_CODE_VALUE")
    private String mimCodeValue;
    @Column(name = "MIM_CODE_VALUE_DESC")
    private String mimCodeValueDesc;
}
