package com.betek.gym.external;

import com.betek.gym.external.dto.TrainingDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "MicroB", url = "http://localhost:8081")
public interface TrainingClient {

    @PostMapping("/trainings")
    TrainingDTO saveTraining(@RequestBody TrainingDTO trainingDTO);

    @GetMapping("/trainings/{apprenticeId}")
    TrainingDTO getTrainingByApprenticeId(@PathVariable("apprenticeId") String apprenticeId);

}