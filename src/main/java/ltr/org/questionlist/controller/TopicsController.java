package ltr.org.questionlist.controller;

import jakarta.validation.Valid;
import ltr.org.questionlist.beans.ServiceResponse;
import ltr.org.questionlist.beans.TopicsRequestBean;
import ltr.org.questionlist.service.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/topic")
public class TopicsController {
    private final TopicsService topicsService;

    @Autowired
    public TopicsController(TopicsService topicsService) {
        this.topicsService = topicsService;
    }

    @PostMapping(value = "/createTopic", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResponse> createTopic(@Valid @RequestBody TopicsRequestBean topicsRequestBean) {
        ServiceResponse serviceResponse = topicsService.createTopic(topicsRequestBean);
        return ResponseEntity.status(serviceResponse.getStatus())
                .body(serviceResponse);
    }

    @PutMapping(value = "/updateTopic", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResponse> updateTopic(@Valid @RequestBody TopicsRequestBean topicsRequestBean) {
        ServiceResponse serviceResponse = topicsService.updateTopic(topicsRequestBean);
        return ResponseEntity.status(serviceResponse.getStatus())
                .body(serviceResponse);
    }
}
