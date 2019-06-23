package springboot.scheduletask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sun.management.OperatingSystemMXBean;

import springboot.modal.vo.LogVo;
import springboot.service.ILogService;
import springboot.service.IMailService;
import springboot.util.DateKit;


/**
 * @author tangj
 * @date 2018/5/2 22:59
 */
@Component
public class ScheduleTask {

    @Resource
    ILogService logService;

    @Resource
    IMailService mailService;

    @Value("${spring.mail.username}")
    private String mailTo;
    
    @Value("${spring.mail.wifemail}")
    private String wifeMail;

    @Scheduled(fixedRate = 86400000)
    public void process(){
    	
    	this.initData();
    	
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
        mailService.sendSimpleEmail(mailTo,"博客系统运行情况",result.toString());
        
        int index =  new Random().nextInt(100);
        
        System.out.println(wifeMail+"############################################");
        
        mailService.sendSimpleEmail(wifeMail, "脑公学习工作情况", "他又把项目重新构建了一遍，其中有个子项目就是只有\n他自己和婉宝才能看见，里面全是你们的聊天记录love-love,也不知道害臊！！！😔，我都看不下去了"
        									+ "\n\n\n\n																--from JDKBlog博客系统管理员"
        									+ "\n\n\n 吃早饭去！！！  来给你讲个笑话，听好了啊！"
        									+ "\n\n\n"+smileSentence.get(index%100));

        mailService.sendSimpleEmail(mailTo, "脑公学习工作情况", "他又把项目重新构建了一遍，其中有个子项目就是只有\n他自己和婉宝才能看见，里面全是你们的聊天记录love-love,也不知道害臊！！！😔，我都看不下去了"
        									+ "\n\n\n\n																--from JDKBlog博客系统管理员"
        									+ "\n\n\n累了吧！！！  来给你讲个笑话，听好了啊！"
        									+ "\n\n\n"+smileSentence.get(index%100));
    }

    public static String getMemery() {

        OperatingSystemMXBean osmxb = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
        long totalvirtualMemory = osmxb.getTotalSwapSpaceSize(); // 剩余的物理内存
        long freePhysicalMemorySize = osmxb.getFreePhysicalMemorySize();
        Double compare = (Double) (1 - freePhysicalMemorySize * 1.0 / totalvirtualMemory) * 100;
        String str = compare.intValue() + "%";
        return str;

    }
    
    /**
     * 能让宝宝笑得开心的数据容器
     */
    private static  List<String> smileSentence = null;
    
    /**
     * 同步函数，维护一个静态变量smileSentence的值。
     */
    public synchronized void  initData() {
    	
    	if(smileSentence!=null)
    		return;
    		
    	smileSentence = new ArrayList<String>();
    	String fileName = this.getClass().getResource("/").getPath().substring(1)+"smile.txt";
    	System.out.println(fileName+"######################################################################");
    	
    	File file = new File(fileName);
    	try {

        	FileInputStream fi = new FileInputStream(file);
    		
			Scanner scanner = new Scanner(getClass().getClassLoader().getResourceAsStream("smile.txt"));
			
			String linestr = null;
			StringBuffer stringBuffer = new StringBuffer();
			boolean first = true;
			for(;scanner.hasNextLine();)
			{
//				System.out.println(str = scan.nextLine().toString()); 
				linestr = scanner.nextLine().toString();
				//空字符串跳过
				if(linestr.trim().equals("")) continue;
				String str = this.getStartDigitsV01(linestr);
				if(first&&str!=null) {
					stringBuffer.append(linestr.substring(str.length()+1, linestr.length()));
					first = false;
					continue;
				}
				
				if(str==null)
				{
					stringBuffer.append(linestr);
					continue;
				}
				
				if(str!=null)
				{
					smileSentence.add(stringBuffer.toString());
					stringBuffer.delete(0, stringBuffer.length());
					stringBuffer.append(linestr.substring(str.length()+1, linestr.length()));
					continue;
				}
			}
			
			smileSentence.add(stringBuffer.toString());
			
//			for(String s:smileSentence)
//				System.out.println(s);
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    /**getStartDigits方法的改版，进一步提升了性能
     * version0.1
     * @param str
     * @return
     */
    public static String getStartDigitsV01(String str) {
        int len = str.length();
        int stopPos = 0;
        for (int i = 0; i < len; i++) { // 遍历 str 的字符
            char ch = str.charAt(i);
            if (!(ch >= '0' && ch <= '9')) { // 如果当前字符不是数字
                stopPos = i;
                break;
            }
        }
        
        if(stopPos == 0)
        	return null;
        
        return str.substring(0, stopPos);
    }
    
    // 取出字符串前面的数字
    /**
     * 这是个工具方法，用于判断一行字符串数据的前面部分的数字以及取出数字
     * @param str
     * @return
     */
    public static String getStartDigits(String str) {
        int len = str.length();
        int stopPos = 0;
        for (int i = 0; i < len; i++) { // 遍历 str 的字符
            char ch = str.charAt(i);
            if (!(ch >= '0' && ch <= '9')) { // 如果当前字符不是数字
                stopPos = i;
                break;
            }
        }
        return str.substring(0, stopPos);
    }
    
//    public static void main(String[] args) throws Exception {
//    		System.out.println(Thread.currentThread().getContextClassLoader().getResource("")); 
//    		System.out.println(ScheduleTask.class.getClassLoader().getResource("")); 
//    		System.out.println(ClassLoader.getSystemResource("")); 
//    		System.out.println(ScheduleTask.class.getResource("")); 
//    		System.out.println(ScheduleTask.class.getResource("/")); //Class文件所在路径  
//    		System.out.println(new File("/").getAbsolutePath()); 
//    		System.out.println(System.getProperty("user.dir"));
////    		System.out.println(System.getProperty("java.class.path"));
//    		
////    		new ScheduleTask().initData();
//    	}
}
