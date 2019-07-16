package springboot.config.clusterconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import springboot.config.ClusterRedisConfig;

@Configuration
@EnableCaching
public class DefaultRedisConfig extends ClusterRedisConfig{

	 	@Value("${spring.redis.database}")
	    private int dbIndex;

	    @Value("${spring.redis.host}")
	    private String host;

	    @Value("${spring.redis.port}")
	    private int port;

	    @Value("${spring.redis.password}")
	    private String password;

	    @Value("${spring.redis.timeout}")
	    private int timeout;
	    
	    @Bean
	    public RedisConnectionFactory defaultRedisConnectionFactory() {
	        return createJedisConnectionFactory(dbIndex, host, port, password, timeout);
	    }

	    /**
	     * 配置redisTemplate 注入方式使用@Resource(name="") 方式注入
	     */
	    @Bean(name = "defaultRedisTemplate")
	    public RedisTemplate defaultRedisTemplate() {
	        RedisTemplate template = new RedisTemplate();
	        template.setConnectionFactory(defaultRedisConnectionFactory());
	        setSerializer(template);
	        template.afterPropertiesSet();
	        return template;
	    }
}
