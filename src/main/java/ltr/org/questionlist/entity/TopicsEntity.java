package ltr.org.questionlist.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="topics_m", schema="common_masters")
@ToString(callSuper = true)
@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class TopicsEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "topic_m_seq")
    @SequenceGenerator(name = "topic_m_seq", sequenceName = "topic_m_seq", allocationSize = 1)
    @Column(name = "TOPIC_ID")
    private Long topicId;
    @Column(name = "TOPIC_NAME")
    private String topicName;
}
