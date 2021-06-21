package lesson.services;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("greetingService")
@Scope("prototype")
@Qualifier("main")
public class GreetingServiceImpl implements GreetingService {
    private ApplicationContext context;

    @Override
    public String sayGreeting() {
        return "Greeting, user!";
    }

    @PostConstruct
    public void postConstructMethod() {

    }

    @PreDestroy
    public void preDestroy() {

    }

//    @Required
//    public void setContext(ApplicationContext context) {
//        this.context = context;
//    }
}