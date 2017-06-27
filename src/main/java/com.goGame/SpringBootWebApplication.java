package com.goGame;

import com.goGame.Dao.DaoPackage;
import com.goGame.commands.CommandsPackage;
import com.goGame.controller.ControllerPackage;
import com.goGame.domain.DomainPackage;
import com.goGame.service.ServicePackage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by ravi on 27/6/17.
 */

@EnableTransactionManagement
@org.springframework.boot.autoconfigure.SpringBootApplication(scanBasePackageClasses = { ControllerPackage.class,
        CommandsPackage.class,
        DaoPackage.class,
        DomainPackage.class,
        ServicePackage.class,

})
public class SpringBootWebApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootWebApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }
}
