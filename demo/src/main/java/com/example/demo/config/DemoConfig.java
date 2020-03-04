package com.example.demo.config;

import com.example.demo.model.Book;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration:表示该类是一个配置类。spring boot建议我们使用该注解来代替传统的xml配置文件；
 @Configuration包含了@Component。所以加了@Configuration注解的类会自动纳入spring容器
 相当于xml中的<beans></beans>

 @Bean:让Spring容器管理创建的对象,默认对象名就是方法名
 @Qualifier("book"): 指定注入的对象名
 */
@Configuration
public class DemoConfig {

    @Value("${spring.datasource.username}")
    private String username;

    @Bean
    public Book demoBook(){
        Book book = new Book();
        book.setBname("时间都去哪儿了");
        book.setId(1);
        book.setAuthor(username);
        return book;
    }

    @Bean
    public User demoUser(@Qualifier("demoBook") Book book){
        User user = new User();
        user.setName("张三");
        user.setBook(book);
        return user;
    }

}
