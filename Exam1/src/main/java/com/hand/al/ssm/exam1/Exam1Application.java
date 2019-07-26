package com.hand.al.ssm.exam1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.hand.al.ssm.exam1.mapper")
@PropertySource("classpath:db.properties")
public class Exam1Application {
    private static Logger log = LoggerFactory.getLogger(Exam1Application.class);
    public static void main(String[] args) {
        log.info("测试日志");
        SpringApplication.run(Exam1Application.class, args);
    }

}
