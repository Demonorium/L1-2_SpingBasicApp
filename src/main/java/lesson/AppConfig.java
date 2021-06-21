package lesson;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class AppConfig {
    // Для testing
    @Bean
    @Profile("dev")
    public DataSource devDataSource() {
//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.HSQL)
//                .addScript("classpath:schema.sql")
//                .addScript("classpath:test-data.sql")
//                .build();
        return null;
    }

    // Для production
    @Bean
    @Profile("production")
    public DataSource productionDataSource() throws Exception {
//        Context ctx = new InitialContext();
//        return (DataSource) ctx.lookup("java:comp/env/jdbc/datasource");
        return null;
    }

}
