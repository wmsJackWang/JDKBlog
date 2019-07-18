package springboot.scheduletask.mytest;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.data.redis.core.RedisTemplate;

import springboot.service.IMailService;
import springboot.service.impl.ClusterRedisService;
import springboot.util.StringHashUtils;
import springboot.util.UserDataUtil;

/*
 * 描述：redis实现mysql库user数据去重
 * 创建不重复name的用户信息redis缓存，使用redis的key不重复特性，实现数据去重需求
 * 问题：速度慢
 * 数据：一万条数据，借助redis去重，需要60s时间插入到数据库中，而批量插入一万条数据只需要0.5s，因此这个方法耗时过于严重。
 */

 /*
  *  username的创建算法，效率极高，一万条字符串中出现重复的数据是1，2条，效率接近100%
  */
public class WriteUserDataToBaseVersion0 { 

	public static void main(String[] args)  {
		
//		try {
//			new WriteUserDataToBaseVersion0().createUserData();
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		}
	public void createUserData(ClusterRedisService redisClient ,IMailService mailService , String mailTo)  throws ClassNotFoundException, SQLException{
		 // 1.加载数据访问驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.连接到数据"库"上去
        Connection conn= DriverManager.getConnection("jdbc:mysql://192.168.3.9:3306/myproject?characterEncoding=GBK&useSSL=false", "jackdking", "ncl@1234");
        //3.构建SQL命令
        Statement state=conn.createStatement();
        //3.构建批量sql命令语句
        PreparedStatement pstate = conn.prepareStatement("");
//        String s="insert into register_user_info (username,password,gender) values('qwewqeqwe','ncl@1234','male')";
        StringBuilder stb = new StringBuilder();
        Long begin = System.currentTimeMillis();
        long i = 0L;
        
        //redis 工具
//        RedisClient redisClient = new RedisClient();
        

        
        /*
         * 一条一条写数据太慢，改进批量提交入库
         */
//		while(i<500000000L){
//			System.out.println(i++);
//			
//			stb.delete(0, stb.length());
//			
//			stb.append("insert into register_user_info (username,password,gender) values");
//			stb.append("(");
//			
//			stb.append("\'");
//			stb.append(UserDataUtil.getUserIds(new ArrayList(), 1).get(0));
//			stb.append("\'");
//			stb.append(",");
//			
//			stb.append("\'");
//			stb.append(UserDataUtil.getPasswords(1, 10).get(0));
//			stb.append("\'");
//			stb.append(",");
//			
//			stb.append("\'");
//			stb.append(UserDataUtil.getGender());
//			stb.append("\'");
//			
//
//			stb.append(")");
//			state.executeUpdate(stb.toString());
//		}
        
        String sqlPre = "insert into user (username,password,gender) values";
        StringBuffer sbf = new StringBuffer();
        //设置为非自动提交
        conn.setAutoCommit(false); 
        int nameNum = 0 , uniqueName = 0;
        String name =  null;
		boolean isExist = false;
		boolean continueok = false;
        while(i<10000) {
        	int j = 0 ;
        	nameNum = 0 ;
        	uniqueName = 0;
        	RedisTemplate<String, Object> redis =null;
        	Long beginTime = System.currentTimeMillis();
        	for(; j < 10000 ; ) {
        		//获取一个用户编号
        		name = UserDataUtil.getUserName(new ArrayList(), 1).get(0).toString();
        		int hash = 0;
				try {
					hash = StringHashUtils.md5(name).hashCode()%2;
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		System.out.println(hash+"#########################################################");
        		if(hash*hash==0) {
        			redis = redisClient.getDefaultRedis();
        		}
        		else {
        			redis = redisClient.getCacheRedis();
        		}
//        		RedisTemplate<String, Object> redis = 
        		++nameNum;
        		continueok = false;
        		try {
        			//查找key,存在返回true
        			isExist = redis.hasKey(name);
//        			System.out.println(isExist);
					String value = "1";
					//每次put，都会去查找key，存在则覆盖，不存在则新建
					//可优化成，通过isExist来判断是否要put，可以减少key的查找
					if(!isExist)//不存在就去put
						redis.opsForValue().set(name, value);
					++uniqueName;
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
					continueok = true ;
					System.out.println("redis error");
				}
        		
        		//如果redis命令出错，直接重新来过
        		if(continueok) continue;
        		
        		if(!isExist) {
	        		//如果不存在这个name，则put到redis中
	        		
	        		
	        		//只有创建了一个不重复的用户名才能自增
	        		++j;
	        		
	        		sbf.append("(");
	    			
	        		sbf.append("\'");
	        		sbf.append(name);
	    			sbf.append("\'");
	    			sbf.append(",");
	    			
	    			sbf.append("\'");
	    			sbf.append(UserDataUtil.getPasswords(1, 10).get(0));
	    			sbf.append("\'");
	    			sbf.append(",");
	    			
	    			sbf.append("\'");
	    			sbf.append(UserDataUtil.getGender());
	    			sbf.append("\'");
	    			
	    
	    			sbf.append("),");
	    			
        		}
        	}
        	String sql = sqlPre + sbf.substring(0, sbf.length()-1);
        	pstate.addBatch(sql);
        	String msg = "总共插入数据的数量:"+pstate.executeBatch();
        	
        	System.out.println(msg);
        	mailService.sendSimpleEmail(mailTo,"一万条数据插入操作",msg);
        	
        	conn.commit();
        	
        	sbf.delete(0, sbf.length());
        	
        	++i;
        	Long endTime = System.currentTimeMillis();
        	msg=i*j+"一万条数据被入库需要时间："+String.valueOf(endTime - beginTime)+" 总共生产用户名次数："
					+String.valueOf(nameNum)+"  唯一用户名生成效率：" + String.valueOf((uniqueName*1.0/nameNum));

        	mailService.sendSimpleEmail(mailTo,"一万条数据插入操作",msg);
        	System.out.println(msg);
        }
        
		
		long end = System.currentTimeMillis();
		String msg = "所有数据写入数据写入MySQL耗时:" + (end - begin)+"毫秒";

    	mailService.sendSimpleEmail(mailTo,"一万条数据插入操作",msg);
		System.out.println(msg);
		
	
	}
}
