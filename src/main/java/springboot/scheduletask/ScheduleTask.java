package springboot.scheduletask;

import java.lang.management.ManagementFactory;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sun.management.OperatingSystemMXBean;

import springboot.modal.vo.LogVo;
import springboot.service.ILogService;
import springboot.service.IMailService;
import springboot.service.impl.ClusterRedisService;
import springboot.service.impl.RedisService;
import springboot.util.DateKit;


/**
 * @author tangj
 * @date 2018/5/2 22:59
 */
@Component
public class ScheduleTask {
	
	@Resource
	private RedisService redisService;
	
	@Resource
	private ClusterRedisService clusterRedisService;
	
	public ScheduleTask() {
		// TODO Auto-generated constructor stub
	}

    @Resource
    ILogService logService;

    @Resource
    IMailService mailService;

    @Value("${spring.mail.username}")
    private String mailTo;
    
    @Value("${spring.mail.wifemail}")
    private String wifeMail;
    
    
    


    @Scheduled(fixedRate =10800000)
    public void process(){
  
    	String IP = null;
//        try {
//        		IP = InetAddress.getLocalHost().getHostAddress();
// 		} catch (UnknownHostException e) {
// 			// TODO Auto-generated catch block
// 			e.printStackTrace();
// 		}
    	
        StringBuffer result = new StringBuffer();
        long totalMemory = Runtime.getRuntime().totalMemory();
        result.append("使用的总内存为："+totalMemory/(1024*1024)+"MB").append("\n");
        result.append("内存使用率为："+getMemery()).append("\n");
        List<LogVo> logVoList = logService.getLogs(0,5);
        for (LogVo logVo:logVoList){
            result.append(" 时间: ").append(DateKit.formatDateByUnixTime(logVo.getCreated()));
            result.append(" 操作: ").append(logVo.getAction());
            result.append(" IP： ").append(logVo.getIp()).append("\n");
        }
        mailService.sendSimpleEmail(mailTo,"博客系统运行情况",result.toString()+"IP:"+IP);
        
       
    }

    public static String getMemery() {

        OperatingSystemMXBean osmxb = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
        long totalvirtualMemory = osmxb.getTotalSwapSpaceSize(); // 剩余的物理内存
        long freePhysicalMemorySize = osmxb.getFreePhysicalMemorySize();
        Double compare = (Double) (1 - freePhysicalMemorySize * 1.0 / totalvirtualMemory) * 100;
        String str = compare.intValue() + "%";
        return str;
    }
}
