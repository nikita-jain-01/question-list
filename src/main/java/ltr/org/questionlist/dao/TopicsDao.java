package ltr.org.questionlist.dao;

import ltr.org.questionlist.entity.TopicsEntity;

public interface TopicsDao {
    void createUpdateTopics(TopicsEntity topicsEntity);

    boolean topicNameAlreadyExist(String topicName, String createdBy, Long topicId);

    boolean topicExists(Long topicId, String createdBy);
}
