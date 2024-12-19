package ltr.org.questionlist.daoimpl;

import ltr.org.questionlist.dao.MastersDao;
import ltr.org.questionlist.entity.MastersEntity;
import ltr.org.questionlist.repository.MastersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MastersDaoImpl implements MastersDao {
    private final MastersRepository mastersRepository;

    @Autowired
    public MastersDaoImpl(MastersRepository mastersRepository) {
        this.mastersRepository = mastersRepository;
    }

    @Override
    public void saveMaster(MastersEntity mastersEntity) {
        mastersRepository.save(mastersEntity);
    }

    @Override
    public boolean existsMimCodeAndValue(String mimCode, String mimCodeValue, String createdBy) {
        return mastersRepository.existsByMimCodeIgnoreCaseAndMimCodeValueIgnoreCaseAndCreatedByIgnoreCaseAndIsDeletedIgnoreCaseNot(mimCode, mimCodeValue, createdBy, "Y");
    }

    @Override
    public Optional<MastersEntity> findMasterDetails(Long masterId) {
        return mastersRepository.findByMasterIdAndIsDeletedNotIgnoreCase(masterId, "Y");
    }
}
