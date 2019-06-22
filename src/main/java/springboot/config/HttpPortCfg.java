package springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
 * //springboot框架配置文件信息生成逻辑
 * 两个注解@Component和@ConfigurationProperties(prefix="指定配置信息的前缀")[指定这个类是一个配置类，加载存放soringboot配置文件中的数据]
 */
@Component
@ConfigurationProperties(prefix = "httpportcfg")
public class HttpPortCfg {
    private String http_port;//http端口

    private String https_port;//https安全端口

    public String getHttp_port() {
        return http_port;
    }

    public void setHttp_port(String http_port) {
        this.http_port = http_port;
    }

    public String getHttps_port() {
        return https_port;
    }

    public void setHttps_port(String https_port) {
        this.https_port = https_port;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "{ httpportcfg:["+"http_port:"+http_port+" "+"https_port:"+https_port+"]}";
    }
}
