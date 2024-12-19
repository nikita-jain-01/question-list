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
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "creation_date_time", updatable = false)
    @CreationTimestamp
    private LocalDateTime creationDateTime;
    @Column(name = "update_date_time")
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
    @Column(name = "is_deleted")
    private String isDeleted;
}
