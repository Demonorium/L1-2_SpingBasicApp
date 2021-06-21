package lesson.services;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class BlackListNotifier implements ApplicationListener {
    private static final Logger logger = LogManager.getLogger(BlackListNotifier.class);
    private String notificationAddress;

    public void setNotificationAddress(String notificationAddress) {
        this.notificationAddress = notificationAddress;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof BlackListEvent) {
            BlackListEvent event = (BlackListEvent) applicationEvent;
            logger.info("BLACKLISTED");
            logger.info("Address: " + event.getAddress());
            logger.info("MSG: " + event.getTest());
        }
    }
}
