package ltr.org.questionlist.daoimpl;

import ltr.org.questionlist.dao.TopicsDao;
import ltr.org.questionlist.entity.TopicsEntity;
import ltr.org.questionlist.repository.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TopicsDaoImpl implements TopicsDao {

    private final TopicsRepository topicsRepository;

    @Autowired
    public TopicsDaoImpl(TopicsRepository topicsRepository) {
        this.topicsRepository = topicsRepository;
    }

    @Override
    public void createUpdateTopics(TopicsEntity topicsEntity) {
        topicsRepository.save(topicsEntity);
    }

    @Override
    public boolean topicNameAlreadyExist(String topicName, String createdBy, Long topicId) {
        return topicsRepository.existsByTopicNameIgnoreCaseAndCreatedByIgnoreCaseAndTopicIdNot(topicName, createdBy, topicId)>0;
    }

    @Override
    public boolean topicExists(Long topicId, String createdBy) {
        return topicsRepository.existsByTopicIdAndCreatedByIgnoreCaseAndIsDeletedNot(topicId, createdBy, "Y");
    }
}
