package com.telusko.SpringBootJDBC;

import com.telusko.SpringBootJDBC.model.Alien;
import com.telusko.SpringBootJDBC.repo.Alienrepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringBootJdbcApplication.class, args);
	  Alien a=context.getBean(Alien.class);

        Alienrepo repo=context.getBean(Alienrepo.class);
        repo.save(a);

        System.out.println(repo.getAlien());
    }

}
