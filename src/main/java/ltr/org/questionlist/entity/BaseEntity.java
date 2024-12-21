package ltr.org.questionlist.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "CREATION_DATE_TIME", updatable = false)
    @CreationTimestamp
    private LocalDateTime creationDateTime;
    @Column(name = "UPDATE_DATE_TIME")
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
    @Column(name = "IS_DELETED")
    private String isDeleted;
}
