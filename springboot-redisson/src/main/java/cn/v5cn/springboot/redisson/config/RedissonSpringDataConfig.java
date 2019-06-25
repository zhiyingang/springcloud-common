/*
package cn.v5cn.redisson.demo.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.data.connection.RedissonConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;

import java.io.IOException;

@Configuration
public class RedissonSpringDataConfig {

    @Bean
    public RedissonConnectionFactory redissonConnectionFactory(RedissonClient redisson) {
        return new RedissonConnectionFactory(redisson);
    }

    @Profile("dev")
    @Bean(destroyMethod = "shutdown")
    public RedissonClient redisson(@Value("classpath:/redisson-dev.yaml") Resource configFile) throws IOException {
        Config config = Config.fromYAML(configFile.getInputStream());
        return Redisson.create(config);
    }

}
*/