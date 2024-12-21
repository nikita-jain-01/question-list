package ltr.org.questionlist.repository;

import ltr.org.questionlist.entity.MastersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MastersRepository extends JpaRepository<MastersEntity, Long> {
    Optional<MastersEntity> findByMasterIdAndIsDeletedNotIgnoreCase(Long masterId, String isDeleted);

    @Query(value = "select count(1) from common_masters.masters_m where upper(mim_code)=upper(:mimCode) and upper(mim_code_value)=upper(:mimCodeValue) and upper(created_by)=upper(:createdBy) and (:masterId is null or master_id!=:masterId)", nativeQuery = true)
    int existsByMimCodeIgnoreCaseAndMimCodeValueIgnoreCaseAndCreatedByIgnoreCaseAndMasterIdNot(String mimCode, String mimCodeValue, String createdBy, Long masterId);

    @Modifying
    int deleteByMasterId(Long masterId);
}
