package lesson;

import lesson.services.BeanWithDependency;
import lesson.services.EmailService;
import lesson.services.GreetingService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Locale;

public class Starter {
    private static final Logger logger = LogManager.getLogger(Starter.class);

    public static void main(String[] args) {
        logger.info("Starting configuration...");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("dev");
        context.register(LessonsConfiguration.class, AppConfig.class);
        context.refresh();

        logger.info("Message: " + context.getMessage("message", null, Locale.getDefault()));
        logger.info("Argument.required: " + context.getMessage("argument.required", new Object[]{"Test_Argument"}, Locale.UK));

        GreetingService greetingService = context.getBean(GreetingService.class);
        BeanWithDependency withDependency = context.getBean(BeanWithDependency.class);

        logger.info(greetingService.sayGreeting());  // "Greeting, user!"
        logger.info(withDependency.sayGreeting());


        EmailService mail = context.getBean(EmailService.class);
        ArrayList<String> list = new ArrayList<>();
        list.add("TEST");
        mail.setBlackList(list);
        mail.sendEmail("TEST", "hello world");
    }
}
