package springboot.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import springboot.anoation.RDS;
import springboot.enums.RedisDataSource;
import springboot.service.IMailService;
import springboot.util.DynamicRedisDataSourceHolder;

@Component
public class ClusterRedisService {

//	@Resource(name = "defaultRedisTemplate")
//	private RedisTemplate<String, Object> defaultRedisTemplate;
	@Autowired
	@Qualifier("defaultRedisTemplate")
	private RedisTemplate<String, Object> defaultRedisTemplate;
	
	@Autowired
	@Qualifier("defaultRedisTemplate")
	private RedisTemplate<String, Object> cacheRedisTemplate;
	
	private RedisTemplate<String, Object> currentRedisTemplate = null;
	
	
	public RedisTemplate<String, Object> redisTemplate(){
		currentRedisTemplate = defaultRedisTemplate;//默认数据源
		switch (DynamicRedisDataSourceHolder.getRedisDataSourceName()) {
		case "9":
			currentRedisTemplate =  defaultRedisTemplate;
			break;
			
		case "11":
			currentRedisTemplate = cacheRedisTemplate;
			break;

		default:
			currentRedisTemplate = defaultRedisTemplate;//默认数据源
			break;
		}

		return currentRedisTemplate;
	}
	
	@RDS(value=RedisDataSource.REDIS_DATASOURCE_DEFAULT)
	public RedisTemplate<String, Object> getDefaultRedis(){
		return redisTemplate();
	}
	
	@RDS(value=RedisDataSource.REDIS_DATASOURCE_REDIS_11)
	public RedisTemplate<String, Object> getCacheRedis(){
		return redisTemplate();
	}
	
}
