package zookeeper;

import java.util.List;

public class Demo {
	public static void main(String[] args) {
		BaseZookeeper zookeeper = new BaseZookeeper();
		try {
			zookeeper.connectZookeeper("192.168.3.9:2181");
			while(true) {
				List<String> children = zookeeper.getChildren("/");
	
				System.out.println(children);
				Thread.sleep(5000);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
	}
}
