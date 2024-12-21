package ltr.org.questionlist.service;

import ltr.org.questionlist.beans.ServiceResponse;
import ltr.org.questionlist.beans.TopicsRequestBean;
import ltr.org.questionlist.beans.TopicsResponseBean;
import ltr.org.questionlist.dao.TopicsDao;
import ltr.org.questionlist.entity.TopicsEntity;
import ltr.org.questionlist.exception.UserValidationException;
import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class TopicsService {
    private final TopicsDao topicsDao;

    @Autowired
    public TopicsService(TopicsDao topicsDao) {
        this.topicsDao = topicsDao;
    }

    @Transactional
    public ServiceResponse createTopic(TopicsRequestBean topicsRequestBean) {
        if(!ObjectUtils.isEmpty(topicsRequestBean.getTopicId()))
            throw new UserValidationException("Topic Id should be null");
        if(topicsDao.topicNameAlreadyExist(topicsRequestBean.getTopicName(), topicsRequestBean.getCreatedBy(), topicsRequestBean.getTopicId()))
            throw new UserValidationException("Topic Name already present");
        TopicsEntity topicsEntity = new ModelMapper().map(topicsRequestBean, TopicsEntity.class);
        topicsDao.createUpdateTopics(topicsEntity);
        TopicsResponseBean topicsResponseBean = new ModelMapper().map(topicsEntity, TopicsResponseBean.class);
        return ServiceResponse.builder()
                .status(HttpStatus.CREATED.value())
                .data(topicsResponseBean)
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @Transactional
    public ServiceResponse updateTopic(TopicsRequestBean topicsRequestBean) {
        if(ObjectUtils.isEmpty(topicsRequestBean.getTopicId()))
            throw new UserValidationException("Topic Id should not be null");
        if(!topicsDao.topicExists(topicsRequestBean.getTopicId(), topicsRequestBean.getCreatedBy()))
            throw new UserValidationException("Topic does not Exist");
        if(topicsDao.topicNameAlreadyExist(topicsRequestBean.getTopicName(), topicsRequestBean.getCreatedBy(), topicsRequestBean.getTopicId()))
            throw new UserValidationException("Topic Name already present");
        TopicsEntity topicsEntity = new ModelMapper().map(topicsRequestBean, TopicsEntity.class);
        topicsDao.createUpdateTopics(topicsEntity);
        TopicsResponseBean topicsResponseBean = new ModelMapper().map(topicsEntity, TopicsResponseBean.class);
        return ServiceResponse.builder()
                .status(HttpStatus.OK.value())
                .data(topicsResponseBean)
                .timeStamp(LocalDateTime.now())
                .build();
    }
}
