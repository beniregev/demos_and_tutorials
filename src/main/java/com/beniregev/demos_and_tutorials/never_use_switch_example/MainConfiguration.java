package com.beniregev.demos_and_tutorials.never_use_switch_example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

/**
 * @author Binyamin Regev e-mail: beniregev@gmail.com
 * @since 1.8
 */
@Configuration
@ComponentScan
@EnableScheduling
public class MainConfiguration {
    @Bean
    public Map<Integer,MailGenerator> generatorMap(List<MailGenerator> mailGenerators){
        return mailGenerators.stream().collect(toMap(MailGenerator::getMyCode, identity()));
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);
        System.out.println();
    }
}
