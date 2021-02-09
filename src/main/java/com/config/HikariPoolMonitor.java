package com.config;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariPoolMXBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2021/2/1.
 */
@Configuration
@EnableScheduling
@Slf4j
public class HikariPoolMonitor {

    @Resource
    private HikariDataSource hikariDataSource;

//    @Scheduled(fixedRate = 500)
    public void printSchedule() {
        HikariPoolMXBean mxBean = hikariDataSource.getHikariPoolMXBean();
        log.info("监控指标： "
                 + " 活跃连接：" + mxBean.getActiveConnections()
                 + " 空闲连接：" + mxBean.getIdleConnections()
                 + " 等待获取的线程：" + mxBean.getThreadsAwaitingConnection()
                 + " 总连接数：" + mxBean.getTotalConnections());
    }
}
