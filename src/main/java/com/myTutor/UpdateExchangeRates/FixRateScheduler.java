package com.myTutor.UpdateExchangeRates;


import com.myTutor.service.ExRateService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FixRateScheduler {

    private final ExRateService exRateService;

    public FixRateScheduler(ExRateService exRateService) {
        this.exRateService = exRateService;
    }

    @Scheduled(fixedRate = 3600000)    //Update once per hoer   @Scheduled(cron = „0 * * * * ?“)    @Scheduled(fixedDelay = 5000 )
    public void onFixedRate(){

        System.out.println("The Exchange Rates were updated!");

            exRateService.updateRates(exRateService.fetchExRates());

    }

}
