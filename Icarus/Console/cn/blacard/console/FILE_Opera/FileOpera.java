package cn.blacard.console.FILE_Opera;

import cn.blacard.console.xiaoqiu.Qiu;

public class FileOpera {
	public static void start(){
		OrderDeal.curSystemInfo();
		while(true){
			String[] orders = Qiu.getOrders();
			Order.deal(orders);
		}
	}
}
