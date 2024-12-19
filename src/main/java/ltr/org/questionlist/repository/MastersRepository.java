package ltr.org.questionlist.repository;

import ltr.org.questionlist.entity.MastersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MastersRepository extends JpaRepository<MastersEntity, Long> {
    boolean existsByMimCodeIgnoreCaseAndMimCodeValueIgnoreCaseAndCreatedByIgnoreCaseAndIsDeletedIgnoreCaseNot(String mimCode, String mimCodeValue, String createdBy, String isDeleted);
    Optional<MastersEntity> findByMasterIdAndIsDeletedNotIgnoreCase(Long masterId, String isDeleted);
}
