package cn.blacard.console.FILE_Opera;

import cn.blacard.console.xiaoqiu.Qiu;

public class Order {
	protected static void deal(String[] orders){
		switch(orders[0]){
		case "test":
			Qiu.say("文件操作测试");
			break;
		case "退出":
			Qiu.say("主人再见~ (o^0^o)/~~~~~~~バイバ～イ！！");
			System.exit(0);
			break;
		default :
			Qiu.say("Oh My Master ,您输的都是什么鬼(つಥ㉨ಥ)つ");
		}
	}
}