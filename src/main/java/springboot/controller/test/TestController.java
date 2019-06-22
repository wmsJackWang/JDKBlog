package springboot.controller.test;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.config.HttpPortCfg;
import springboot.config.NettyServerConfig;
import springboot.controller.AbstractController;
import springboot.exception.TipException;


@Controller
@RequestMapping("/test")
@Transactional(rollbackFor=TipException.class)
public class TestController extends AbstractController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);


    @Resource
    private Configurationinfo  configurationinfo ;
    
    @Resource
	private HttpPortCfg httpPortCfg;
    
    @Resource
	private NettyServerConfig nettyServerConfig;
    
    
    @GetMapping("/tst")
    public String test(){

      System.out.println(configurationinfo.toString());
      System.out.println(nettyServerConfig.toString());
      System.out.println(httpPortCfg.toString()); 
    	
    	return "";
    }
    
   
    
}
