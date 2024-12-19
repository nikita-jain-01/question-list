package ltr.org.questionlist.service;

import ltr.org.questionlist.beans.MasterRequestBean;
import ltr.org.questionlist.beans.MasterResponseBean;
import ltr.org.questionlist.beans.ServiceResponse;
import ltr.org.questionlist.dao.MastersDao;
import ltr.org.questionlist.entity.MastersEntity;
import ltr.org.questionlist.exception.UserValidationException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Service
public class MastersService {

    private final MastersDao mastersDao;

    @Autowired
    public MastersService(MastersDao mastersDao) {
        this.mastersDao = mastersDao;
    }

    @Transactional
    public ServiceResponse createMaster(MasterRequestBean masterRequestBean) {
        if(masterRequestBean.getMasterId()!=null || !ObjectUtils.isEmpty(masterRequestBean.getMasterId()))
            throw new UserValidationException("Master Id should be null during creation");
        if(mastersDao.existsMimCodeAndValue(masterRequestBean.getMimCode(), masterRequestBean.getMimCodeValue(), masterRequestBean.getCreatedBy()))
            throw new UserValidationException("Same Mim Code Value already exist against same Mim code");
        MastersEntity mastersEntity = new ModelMapper().map(masterRequestBean, MastersEntity.class);
        mastersDao.saveMaster(mastersEntity);
        MasterResponseBean masterResponseBean = new ModelMapper().map(mastersEntity, MasterResponseBean.class);
        return ServiceResponse.builder()
                .status(HttpStatus.CREATED.value())
                .data(masterResponseBean)
                .message("Master Created Successfully")
                .build();
    }

    public ServiceResponse updateMaster(MasterRequestBean masterRequestBean) {
        if(masterRequestBean.getMasterId()==null || ObjectUtils.isEmpty(masterRequestBean.getMasterId()))
            throw new UserValidationException("Master Id should not be null during creation");
        if(mastersDao.existsMimCodeAndValue(masterRequestBean.getMimCode(), masterRequestBean.getMimCodeValue(), masterRequestBean.getCreatedBy()))
            throw new UserValidationException("Same Mim Code Value already exist against same Mim code");
        Optional<MastersEntity> masterEntity = mastersDao.findMasterDetails(masterRequestBean.getMasterId());
        if(ObjectUtils.isEmpty(masterEntity))
            throw new UserValidationException("This Master does not exist");
        MastersEntity mastersEntity = new ModelMapper().map(masterRequestBean, MastersEntity.class);
        mastersDao.saveMaster(mastersEntity);
        MasterResponseBean masterResponseBean = new ModelMapper().map(mastersEntity, MasterResponseBean.class);
        return ServiceResponse.builder()
                .status(HttpStatus.CREATED.value())
                .data(masterResponseBean)
                .message("Master Updated Successfully")
                .build();
    }
}
