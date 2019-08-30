package springboot.scheduletask;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import springboot.scheduletask.mytest.WriteUserDataToBaseVersion0;
import springboot.service.IMailService;
import springboot.service.impl.ClusterRedisService;

@Component
public class UserDataCreateSchedule {
	
	
	@Autowired
	private ClusterRedisService clusterRedisService;
	
	@Resource
    IMailService mailService;

    @Value("${spring.mail.username}")
    private String mailTo;
    
    @Value("${spring.mail.wifemail}")
    private String wifeMail;
    
    
	//十天周期重新执行任务
//	@Scheduled(fixedRate =1000*60*60*60*24*10)
	public void CreateUserDataWithRedisCluster() {
		
		try {
			new WriteUserDataToBaseVersion0().createUserData(clusterRedisService,mailService,mailTo);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
