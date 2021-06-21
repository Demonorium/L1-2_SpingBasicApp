package lesson.services;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class BeanWithDependency implements ApplicationListener {
    private static final Logger logger = LogManager.getLogger(BeanWithDependency.class);

    private GreetingService greetingService;
    public BeanWithDependency(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayGreeting() {
        return greetingService.sayGreeting() + " It's long!";
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof BlackListEvent) {
            BlackListEvent event = (BlackListEvent) applicationEvent;
            logger.info(event.getAddress());
            logger.info(event.getTest());
        }
    }
}
