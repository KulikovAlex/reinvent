package com.mediumservice.medium;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigMedium {

    private static final String cmndTopicName = "cmnd-topic";

    private static final String responseTopicName = "response-topic";

    @Value("${redis.hostName}")
    private String redisHost;
    @Value("${redis.port}")
    private int redisPort;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    RedisStandaloneConfiguration redisStandaloneConfiguration() {
        RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration();
        redisConfig.setHostName(redisHost);
        redisConfig.setPort(redisPort);
        return redisConfig;
    }
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory(redisStandaloneConfiguration());
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }

    // Explicitly specifying topics just in case if further topics set up require
    @Bean
    public NewTopic kafkaCmndTopic() {
        return new NewTopic(cmndTopicName, 1, (short) 1);
    }

    @Bean
    public NewTopic kafkaResponseTopic() {
        return new NewTopic(responseTopicName, 1, (short) 1);
    }

}
