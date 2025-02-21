package com.training.ged.controller.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@Log
@RequestMapping("/api")
public class BatchController {

    private final JobLauncher jobLauncher;
    private final Job job;

    @GetMapping("/batch")
    public void startBatch(){
       runBatch();
    }

    // Lancement du Batch toutes les minutes (cron=0 */1 * * * ?)
    @Scheduled(cron = "0 */1 * * * ?")
    public void runBatch(){
        try {
            JobParameters parameters = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .toJobParameters();
            jobLauncher.run(job, parameters);

        }catch (Exception e){
            log.info("Cannot execute batch");
        }
    }


}
