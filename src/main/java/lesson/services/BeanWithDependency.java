package lesson.services;


public class BeanWithDependency {
    private GreetingService greetingService;
    public BeanWithDependency(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayGreeting() {
        return greetingService.sayGreeting() + " It's long!";
    }
}
