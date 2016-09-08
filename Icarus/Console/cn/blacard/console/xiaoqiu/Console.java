package cn.blacard.console.xiaoqiu;

import cn.blacard.console.DB_Opera.DBOpera;

public class Console {
	public static void main(String[] args) {
		
		while(true){
			dealOrders(Qiu.getOrders("Master,见到您小秋很开心。请问小秋能问你做点什么呢"));
		}
	}
	
	
	private static void dealOrders(String[] orders){
		switch(orders[0]){
		case "数据库操作" :
			DBOpera.start();
			break;
		case "文件管理" :
			Qiu.say("文件管理的暂时还没完善好呢Master");
			break;
		case "other" :
			break;
		default: System.out.println("Master,小秋不能理解您的指令");
		}
	}
}
