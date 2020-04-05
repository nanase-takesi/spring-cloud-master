package com.shengda.mybatis;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.shengda.mybatis.handler.DateMetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * @author takesi
 * @date 2020-01-22
 */
@Slf4j
@Import(DateMetaObjectHandler.class)
public class MybatisAutoConfigurer implements CommandLineRunner {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("MybatisAutoConfigurer is running......");
    }

}
