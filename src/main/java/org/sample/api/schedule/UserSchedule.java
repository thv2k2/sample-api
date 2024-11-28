package org.sample.api.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserSchedule {

    @Scheduled(cron = "1 0 0 * * ?")
    @Value("${scheduler.job.enabled}")
    public void updateUser() {
        log.info("Updating user schedule");
    }
}
