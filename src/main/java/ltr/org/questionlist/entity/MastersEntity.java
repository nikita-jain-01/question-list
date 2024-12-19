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
    @Column(name="master_id")
    private Long masterId;
    @Column(name = "mim_code")
    private String mimCode;
    @Column(name = "mim_code_value")
    private String mimCodeValue;
    @Column(name = "mim_code_value_desc")
    private String mimCodeValueDesc;
}
