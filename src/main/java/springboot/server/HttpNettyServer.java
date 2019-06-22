package springboot.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import springboot.server.handler.HttpNettyServerInitializer;
import springboot.util.PortChecker;

import java.net.InetSocketAddress;

/**
 * @author tangj
 * @date 2018/4/15 15:27
 */
//单例模式维护netty服务实例
public class HttpNettyServer {
    private static final Logger logger = LoggerFactory.getLogger(HttpNettyServer.class);

    private Thread startThread = null;

    EventLoopGroup bossGroup = new NioEventLoopGroup();
    EventLoopGroup wokerGroup = new NioEventLoopGroup();

    private String ip = "0.0.0.0";
    private int port = 3560;

    private HttpNettyServer(){
    }

    //静态内部类的静态引用维护实例，类被加载进jvm初始化的时候就已经初始化实例了
    //为什么不用静态内部实例引用 ，而要使用内部静态实例呢
    private static class Inner{
       private static HttpNettyServer instance = new HttpNettyServer();
    }

    public static HttpNettyServer getInstance(){
        return Inner.instance;
    }

    public void start() throws Exception{
        if (!PortChecker.checkPort(null, port)) {
            throw new Exception("请确保所需要内部管理端口" + port + "没有被占用");
        }

        InetSocketAddress addr = new InetSocketAddress(ip,port);
        // 启动ip和端口
        final String adInfo = ip + ":" + port;

        startThread = new Thread(){
            @Override
            public void run(){
                try {
                    ServerBootstrap serverBootstrap = new ServerBootstrap();
                    serverBootstrap.group(bossGroup,wokerGroup)
                                   .channel(NioServerSocketChannel.class)
                                   .handler(new LoggingHandler(LogLevel.INFO))
                                    .childHandler(new HttpNettyServerInitializer());
                    ChannelFuture future = serverBootstrap.bind(new InetSocketAddress(port)).sync();
                    logger.info("HTTP service start success ---"+adInfo);
                    future.channel().closeFuture().sync();
                }catch (Exception e){
                    logger.error("HTTP Service start fail ---"+adInfo+e.getMessage());
                }finally {
                    bossGroup.shutdownGracefully();
                    wokerGroup.shutdownGracefully();
                }
            }
        };
        startThread.start();

    }
}
