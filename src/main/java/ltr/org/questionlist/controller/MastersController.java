package ltr.org.questionlist.controller;

import jakarta.validation.Valid;
import ltr.org.questionlist.beans.MasterRequestBean;
import ltr.org.questionlist.beans.ServiceResponse;
import ltr.org.questionlist.service.MastersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/master")
public class MastersController {

    private final MastersService mastersService;

    @Autowired
    public MastersController(MastersService mastersService) {
        this.mastersService = mastersService;
    }

    @PostMapping(value = "/createMaster", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResponse> createMaster(@Valid @RequestBody MasterRequestBean masterRequestBean) {
        ServiceResponse serviceResponse = mastersService.createMaster(masterRequestBean);
        return ResponseEntity.status(serviceResponse.getStatus())
                .body(serviceResponse);
    }

    @PutMapping(value = "/updateMaster", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResponse> updateMaster(@Valid @RequestBody MasterRequestBean masterRequestBean) {
        ServiceResponse serviceResponse = mastersService.updateMaster(masterRequestBean);
        return ResponseEntity.status(serviceResponse.getStatus())
                .body(serviceResponse);
    }

    @DeleteMapping(value = "/deleteMaster/{masterId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResponse> deleteMaster(@RequestParam Long masterId) {
        ServiceResponse serviceResponse = mastersService.deleteMaster(masterId);
        return ResponseEntity.status(serviceResponse.getStatus())
                .body(serviceResponse);
    }
}
