package cn.blacard.console.FILE_Opera;

import cn.blacard.console.xiaoqiu.QIUSTRING;
import cn.blacard.console.xiaoqiu.Qiu;

public class Order extends OrderDeal{
	protected static void deal(String[] orders){
		switch(orders[0]){
		case "test":
			Qiu.say("文件操作测试");
			break;
		case "see":
			see(orders);
			break;
		case "filter":
			filter(orders);
			break;
		case "退出":
			Qiu.say("主人再见~ (o^0^o)/~~~~~~~バイバ～イ！！");
			System.exit(0);
			break;
		default :
			Qiu.say(QIUSTRING.INPUTERROR);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	protected static void filter(String[] orders){
		switch(orders[2]){
		case ">" :
		case "<":
			filterBySize(orders);
			break;
		case "suffix":
			filterBySuffix(orders);
			break;
			default :Qiu.say(QIUSTRING.INPUTERROR);
		}
	}
	
	protected static void see(String[] orders){
		switch(orders[1]){
			case "sysinfo" :
				curSystemInfo();
				break;
			default : ;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
