package springboot.util;

import springboot.enums.RedisDataSource;

public class DynamicRedisDataSourceHolder {

	private static final ThreadLocal<String> holder = new ThreadLocal<>();
	static {
		
	}
	private DynamicRedisDataSourceHolder() {
		
	}
	public static void setRedisDataSourceName(String name) {
		holder.set(name);
	}
	public static void setRedisDataSourceName(RedisDataSource dataSource) {
		holder.set(dataSource.getValue());
	}
	public static String getRedisDataSourceName() {
		return holder.get();
	}
	public static void removeRedisDataSourceName() {
		holder.remove();
	}
	
	
	
	
}
