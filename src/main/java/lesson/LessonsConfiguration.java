package lesson;

import lesson.services.BeanWithDependency;
import lesson.services.CommandManager;
import lesson.services.GreetingService;
import lesson.services.GreetingServiceImpl;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Конфигурационный класс Spring IoC контейнера
 */
@Configuration
@ComponentScan(basePackages = "lesson.services")
@Import(AnotherConfiguration.class)
public class LessonsConfiguration {
//    @Bean
//    @Description("Текстовое описание бина greetingService")
//    GreetingService greetingService() {
//        return new GreetingServiceImpl();
//    }

    @Bean
    MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    @Bean
    @Scope("prototype")
    public Object asyncCommand() {
        return new Object();
    }
    @Bean
    public CommandManager commandManager() {
        // возвращаем новую анонимную реализацию CommandManager
        // с новым объектом
        return new CommandManager() {
            protected Object createCommand() {
                return asyncCommand();
            }
        };
    }
}