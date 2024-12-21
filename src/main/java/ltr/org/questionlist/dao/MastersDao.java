package ltr.org.questionlist.dao;

import ltr.org.questionlist.entity.MastersEntity;

import java.util.Optional;

public interface MastersDao {
    void saveMaster(MastersEntity mastersEntity);

    boolean existsMimCodeAndValue(String mimCode, String mimCodeValue, String createdBy, Long masterId);

    Optional<MastersEntity> findMasterDetails(Long masterId);

    void deleteMaster(Long masterId);
}
