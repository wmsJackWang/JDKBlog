package springboot.config.clusterconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import springboot.config.ClusterRedisConfig;


@Configuration
@EnableCaching
public class CacheRedisConfig extends ClusterRedisConfig{

	@Value("${spring.redis2.database}")
    private int dbIndex;

    @Value("${spring.redis2.host}")
    private String host;

    @Value("${spring.redis2.port}")
    private int port;

    @Value("${spring.redis2.password}")
    private String password;

    @Value("${spring.redis2.timeout}")
    private int timeout;
	
    
    /**
     * 配置redis连接工厂
     *
     * @return
     */
    @Primary
    @Bean
    public RedisConnectionFactory cacheRedisConnectionFactory() {
        return createJedisConnectionFactory(dbIndex, host, port, password, timeout);
    }

    /**
     * 配置redisTemplate 注入方式使用@Resource(name="") 方式注入
     *
     * @return
     */
    @Bean(name = "cacheRedisTemplate")
    public RedisTemplate cacheRedisTemplate() {
        RedisTemplate template = new RedisTemplate();
        template.setConnectionFactory(cacheRedisConnectionFactory());
        setSerializer(template);
        template.afterPropertiesSet();
        return template;
    }
    
}
