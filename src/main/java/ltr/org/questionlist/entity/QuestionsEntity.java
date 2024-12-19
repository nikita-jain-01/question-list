package ltr.org.questionlist.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="questions_m", schema="common_masters")
@ToString(callSuper = true)
@Getter
@Setter
public class QuestionsEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questions_m_seq")
    @SequenceGenerator(name = "questions_m_seq", sequenceName = "questions_m_seq", schema = "common_masters", allocationSize = 1)
    @Column(name="question_id")
    private Long questionId;
}
