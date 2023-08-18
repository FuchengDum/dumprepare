package com.dum.redis_base.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.support.SimpleTriggerContext;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@PropertySource("classpath:application.properties")
public class RedisConfig {
    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private int port;
    @Value("${redis.maxIdle}")
    private int maxIdle;
    @Value("${redis.maxWaitMillis}")
    private long maxWaitMillis;
    @Value("${redis.blockWhenExhausted}")
    private boolean blockWhenExhausted;
    @Value("${redis.JmxEnabled}")
    private boolean JmxEnabled;
    @Value("${redis.timeout}")
    private int timeout;

    @Bean
    public JedisPool jedisPoolFactory(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
        jedisPoolConfig.setJmxEnabled(JmxEnabled);
        return new JedisPool(jedisPoolConfig, host, port, timeout);
    }
}
