package com.yezi.image;

import com.yezi.image.mysql.MySqlEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class ImageApplication {

    public static void main(String[] args) {
        MySqlEntity mySqlEntity = MySqlEntity.getMySqlEntity();
        SpringApplication.run(ImageApplication.class, args);
    }

}
