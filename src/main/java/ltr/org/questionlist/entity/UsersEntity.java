package ltr.org.questionlist.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="users_m", schema="common_masters")
@ToString(callSuper = true)
@Getter
@Setter
public class UsersEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_m_seq")
    @SequenceGenerator(name = "user_m_seq", sequenceName = "user_m_seq", schema = "common_masters", allocationSize = 1)
    @Column(name="user_id")
    private Long userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_code")
    private String userCode;
}
