package ltr.org.questionlist.repository;

import ltr.org.questionlist.entity.TopicsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopicsRepository extends JpaRepository<TopicsEntity, Long> {
    boolean existsByTopicIdAndCreatedByIgnoreCaseAndIsDeletedNot(Long topicId, String createdBy, String isDeleted);

    @Query(value = "select count(1) from common_masters.topics_m where upper(topic_name)=upper(:topicName) and (is_deleted is null or upper(is_deleted)='N') and upper(created_by)=upper(:createdBy) and (:topicId is null or topic_id != :topicId)", nativeQuery = true)
    int existsByTopicNameIgnoreCaseAndCreatedByIgnoreCaseAndTopicIdNot(String topicName, String createdBy, Long topicId);
}
