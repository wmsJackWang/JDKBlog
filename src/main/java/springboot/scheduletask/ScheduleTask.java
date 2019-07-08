package springboot.scheduletask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
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
	
	public ScheduleTask() {
		// TODO Auto-generated constructor stub
		//初始化数据
		this.initData();
	}

    @Resource
    ILogService logService;

    @Resource
    IMailService mailService;

    @Value("${spring.mail.username}")
    private String mailTo;
    
    @Value("${spring.mail.wifemail}")
    private String wifeMail;
    

    @Scheduled(fixedRate =3000)
    public  void testRedis() {
    	System.out.println("################################################################");
    	System.out.println(redisService.existsKey("testRedis"));
    	mailService.sendSimpleEmail(mailTo,"redis",redisService.existsKey("testRedis")?"true":"false");
    }

    @Scheduled(fixedRate =10800000)
    public void process(){
    	
    	this.initData();
    	int index =  new Random().nextInt(100);
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
        
       
        
        System.out.println(wifeMail+"############################################");
        
        String heart1 = this.getHeart1();
        String heart2 = getHeart2();
        String heart3 = getHeart3();
        String heart4 = getHeart4();
        String heart[] = new String[]{"想婉宝了！",heart1,heart2,heart3,heart4};
        
        
        
        
        mailService.sendSimpleEmail(wifeMail, "脑公学习工作情况", "他又把项目重新构建了一遍，其中有个子项目就是只有\n他自己和婉宝才能看见，里面全是你们的聊天记录love-love,也不知道害臊！！！😔，我都看不下去了"
        									+ "\n\n\n\n																--from JDKBlog博客系统管理员"
        									+ "\n\n\n 王明胜说想你了，他让我转告你！  “想你，宝宝，爱你哟！！！嘿嘿”"
        									+ "\n mua.mua.mua.mua.mua.mua.mua.mua.mua.mua......"
        									+ "\n mua.mua.mua.mua.mua.mua.mua.mua.mua.mua......"
        									+ "\n mua.mua.mua.mua.mua.mua.mua.mua.mua.mua......"
        									+ "\n mua.mua.mua.mua.mua.mua.mua.mua.mua.mua......"
        									+ "\n mua.mua.mua.mua.mua.mua.mua.mua.mua.mua......"
        									+ "\n mua.mua.mua.mua.mua.mua.mua.mua.mua.mua......"
        									+ "凑合着看吧！哎 😔失败的效果图呀！！"
        									+ "\n\n\n\n "+heart[new Random().nextInt(heart.length)]
        									+ "\n\n\n 别饿着哈！！！  来给你讲个笑话，听好了啊！"
        									+ "\n\n\n"+smileSentence.get(index%100)+"IP:"+IP);

        mailService.sendSimpleEmail(mailTo, "脑公学习工作情况", "他又把项目重新构建了一遍，其中有个子项目就是只有\n他自己和婉宝才能看见，里面全是你们的聊天记录love-love,也不知道害臊！！！😔，我都看不下去了"
											+ "\n\n\n\n																--from JDKBlog博客系统管理员"
											+ "\n\n\n 王明胜说想你了，他让我转告你！  “想你，宝宝，爱你哟！！！嘿嘿”"
											+ "\n mua.mua.mua.mua.mua.mua.mua.mua.mua.mua......"
											+ "\n mua.mua.mua.mua.mua.mua.mua.mua.mua.mua......"
											+ "\n mua.mua.mua.mua.mua.mua.mua.mua.mua.mua......"
											+ "\n mua.mua.mua.mua.mua.mua.mua.mua.mua.mua......"
											+ "\n mua.mua.mua.mua.mua.mua.mua.mua.mua.mua......"
											+ "\n mua.mua.mua.mua.mua.mua.mua.mua.mua.mua......"
											+ "\n\n\n\n "+heart[new Random().nextInt(heart.length-1)]
											+ "\n\n\n 别饿着哈！！！  来给你讲个笑话，听好了啊！"
											+ "\n\n\n"+smileSentence.get(index%100)+"IP:"+IP);
    }

    public static String getMemery() {

        OperatingSystemMXBean osmxb = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
        long totalvirtualMemory = osmxb.getTotalSwapSpaceSize(); // 剩余的物理内存
        long freePhysicalMemorySize = osmxb.getFreePhysicalMemorySize();
        Double compare = (Double) (1 - freePhysicalMemorySize * 1.0 / totalvirtualMemory) * 100;
        String str = compare.intValue() + "%";
        return str;

    }
    
    public String getHeart2() {
    	return heart(5,0.3,"love");
    }
    public String getHeart3() {
    	return heartTwo(5,0.3,"爱","罗密欧","朱丽叶");
    }
    public String getHeart4() {
    	return heartTwo(5,0.3,"爱","jack","rose");
    }
    private  String heart(int r,double size,String req){

    	size=1/(1.5*r*size);

    	StringBuilder sb=new StringBuilder();

    	for (int y = r; y > -r; y--,sb.append("\n"))

    	for (int x = -2*r; x < 2*r; x++ ) {

    	char msg=(req + req).charAt((x - y) % req.length() + req.length());

    	sb.append((inHeart(size,x,y)?msg+ " " : " "));

    	}

    	System.out.println(sb.toString());
    	return sb.toString();

    }
    private  String heartTwo(int r,double size,String center,String left,String right){

    	size=1/(1.5*r*size);

    	StringBuilder sb=new StringBuilder();

    	for (int y = r; y > -r; y--,sb.append("\n"))

    	for (int x = -2*r; x <4*r; x++ ) {

    	boolean isLeft=inHeart(size,x,y);

    	boolean isRight=inHeart(size,x-25,y-3);

    	//双空格

    	String req=null;

    	if(isLeft && isRight) req=center;

    	else if(isLeft) req=left;

    	else if (isRight) req=right;

    	if(req!=null) sb.append((req + req).charAt((x - y) % req.length() + req.length()));

    	else sb.append(" ");//双空格

    	}

    	System.err.println(sb.toString());
    	return sb.toString();

    }
    
    private  String heartTwoWithXK(int r,double size,String center,String left,String right){

    	size=1/(1.5*r*size);

    	StringBuilder sb=new StringBuilder();

    	for (int y = r; y >=-r; y--,sb.append("\n"))

    	for (int x = -2*r; x <= 4*r; x++ ) {

    	boolean isLeft=inHeart(size,x,y+3);

    	boolean isRight=inHeart(size,x-25,y);

    	//双空格

    	String req=null;

    	String w="";

    	if(isLeft && isRight) req=center;

    	else if(isLeft) req=left;

    	else if (isRight) req=right;

    	else if((y==-r || y==r)) {

    	if (x < 3 * r - 7) {

    	req = "♥";

    	w = " ";

    	}

    	}

    	else if(x==4*r || x==-2*r || line(x,y+3)) req="♥";

    	if(req!=null) sb.append((req + req).charAt((x - y) % req.length() + req.length()) + w);

    	else sb.append(" ");//双空格

    	}

    	System.out.println(sb.toString());
    	return sb.toString();

    }
    
    private  boolean inHeart(double size,int x,int y){

    	return Math.pow(Math.pow(x * size, 2) + Math.pow(y * 2*size, 2) - 1, 3) - Math.pow(x * size, 2) * Math.pow(y * 2*size, 3) <= 0;

    }
    
    private  boolean line(int x,int y){

    	return 4*y-x == 0;

    	}
    
    public String getHeart1() {
    	StringBuilder heart1 = new StringBuilder();
    	for(float y = (float) 1.5;y>-1.5;y -=0.1)  {  
            for(float x= (float) -1.5;x<1.5;x+= 0.05){  
                  float a = x*x+y*y-1;  
                  if((a*a*a-x*x*y*y*y)<=0.0)  {    
                         System.out.print("^"); 
                         heart1.append("^");
                  }  
                  else  
                  {
                         System.out.print(" "); 
                         heart1.append(" ");
                         
                  }
            }  
            System.out.println();  
            heart1.append("\n");
            
        }  
    	return heart1.toString();
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
    	
    	if(!System.getProperty("os.name").toLowerCase().startsWith("win"))
    		fileName = File.separator+fileName;
    	
    	File file = new File(fileName);
    	try {

        	FileInputStream fi = new FileInputStream(file);
//        	getClass().getClassLoader().getResourceAsStream("smile.txt")
			Scanner scanner = new Scanner(fi);
			
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
//    		System.out.println(System.getProperty("java.class.path"));
//    		InetAddress addr = InetAddress.getLocalHost(); 
//          System.out.println(addr.getHostAddress()+"?###############");
////    		new ScheduleTask().initData();
//    	}
}
