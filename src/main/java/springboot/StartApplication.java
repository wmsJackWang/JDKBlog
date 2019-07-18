package springboot;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

import springboot.config.HttpPortCfg;
import springboot.config.NettyServerConfig;


/*
 * 启动类，所有的springboot项目都会有启动类：springApplication和
 */
@SpringBootApplication 
@EnableScheduling
@MapperScan("springboot.dao")//启动扫描dao包，@Mapper
public class StartApplication extends SpringBootServletInitializer {//springboot如果没有指定@componentScan的话，就会默认扫描StartApplication类所在的包

	
	/* (non-Javadoc)
	 * 修改
	 * @see org.springframework.boot.web.support.SpringBootServletInitializer#configure(org.springframework.boot.builder.SpringApplicationBuilder)
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		// TODO Auto-generated method stub
		return application.sources(StartApplication.class); 
	}
	
	
	
	
	/*
	 * 	# httpportcfg 配置
		httpportcfg:
  		http_port: 8080
  		https_port: 8443

	 */
    @Resource
    private HttpPortCfg httpPortCfg;//此时配置文件中的数据已经加载到这个配置信息对象中去了，默认单例模式

    
    
    /*
     * 
		# Nettyserver 配置
		nettyserver:
  		serviceIp: 0.0.0.0
  		servicePort: 3460
     */
    @Resource
    private NettyServerConfig nettyConfig;//此时配置文件中的数据已经加载到这个配置信息对象中去了，默认单例模式

    public static void main(String[] args) throws Exception{

        SpringApplication app = new SpringApplication(StartApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
//        
//        System.out.println(new StartApplication().nettyConfig.toString());
//        System.out.println(new StartApplication().httpPortCfg.toString()); 

    }


    // datasource配置，阿里的druid连接池
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")//对容器中的对象 通过setter方法进行装载配置信息
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    //mybatis SQLSession注入
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:/mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }


    //事务支持
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

//    // 配置8080端口自动转向8443
//    @Bean
//    public EmbeddedServletContainerFactory servletContainer() {
//        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
//            @Override
//            protected void postProcessContext(Context context) {
//                SecurityConstraint securityConstraint = new SecurityConstraint();
//                securityConstraint.setUserConstraint("CONFIDENTIAL");
//                SecurityCollection collection = new SecurityCollection();
//                collection.addPattern("/*");
//                securityConstraint.addCollection(collection);
//                context.addConstraint(securityConstraint);
//            }
//        };
//
//        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//        connector.setScheme("http");
//        connector.setPort(Integer.valueOf(httpPortCfg.getHttp_port()));
//        connector.setSecure(false);
//        connector.setRedirectPort(Integer.valueOf(httpPortCfg.getHttps_port()));
//
//        tomcat.addAdditionalTomcatConnectors(connector);
//        return tomcat;
//    }

}
