package springboot.enums;

import springboot.enums.base.BaseEnum;

public enum RedisDataSource implements BaseEnum  {
	REDIS_DATASOURCE_DEFAULT("9"),REDIS_DATASOURCE_REDIS_11("11");

	private String redisName;
	
	private RedisDataSource(String name) {
		redisName = name;
	}
	@Override
	public String  getValue() {
		// TODO Auto-generated method stub
		return this.redisName;
	}

}
