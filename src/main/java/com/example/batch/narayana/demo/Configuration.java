package com.example.batch.narayana.demo;

import com.arjuna.ats.arjuna.recovery.RecoveryManager;
import com.arjuna.ats.jbossatx.jta.RecoveryManagerService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean(destroyMethod = "stop")
    @DependsOn({"narayanaPropertiesInitializer"})
    @ConditionalOnProperty(name = "recovery.period.start.disabled", havingValue = "true", matchIfMissing = false)
    public RecoveryManagerService recoveryManagerService() {
        RecoveryManager.delayRecoveryManagerThread();
        RecoveryManagerService recoveryManagerService = new RecoveryManagerService();
        recoveryManagerService.create();
        // recoveryManagerService.start();
        return recoveryManagerService;
    }
}
