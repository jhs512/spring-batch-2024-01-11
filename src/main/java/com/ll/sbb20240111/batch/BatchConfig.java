package com.ll.sbb20240111.batch;

import com.ll.sbb20240111.global.app.AppConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class BatchConfig {
    private final BatchService batchService;

    @Scheduled(cron = "0 0 1 * * *") // 운영
    // @Scheduled(cron = "0 * * * * *") // 테스트
    public void runMakeProductLogJob() {
        if (AppConfig.isNotProd()) return;

        LocalDateTime startDate = LocalDateTime
                .now()
                .minusDays(1)
                .withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);

        LocalDateTime endDate = LocalDateTime
                .now()
                .minusDays(1)
                .withHour(23)
                .withMinute(59)
                .withSecond(59)
                .withNano(999999);

        batchService.runMakeProductLogJob(startDate, endDate);
    }
}
