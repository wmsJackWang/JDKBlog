package springboot.aspect;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import springboot.anoation.RDS;
import springboot.util.DynamicRedisDataSourceHolder;

@Aspect
@Component
@Order(-1)
public class SwitchRDS {
	
	
	
	private static final Logger logger = LogManager.getLogger(SwitchRDS.class);
	
	@Before("@annotation(rds)")
	public void switchRds(RDS rds) {
		
		DynamicRedisDataSourceHolder.setRedisDataSourceName(rds.value());
		String msg = "redis数据源切换为{"+rds.value().getValue()+"}";
		logger.info(msg);
	}

}
