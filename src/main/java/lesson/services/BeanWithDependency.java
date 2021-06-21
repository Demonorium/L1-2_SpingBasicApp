package lesson.services;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class BeanWithDependency {


    private GreetingService greetingService;
    public BeanWithDependency(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayGreeting() {
        return greetingService.sayGreeting() + " It's long!";
    }


}
