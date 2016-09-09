package cn.blacard.console.DB_Opera;

import java.util.logging.Logger;

import cn.blacard.console.xiaoqiu.Qiu;
import cn.blacard.dbopera.opera.Query;
import cn.blacard.dbopera.para.DBConnectPara;

public class Order extends OrderDeal{
	private static Logger log = Logger.getLogger(Order.class.getName());
	private static Query query = new Query();
	
	protected static void deal(String[] orders){

		switch(orders[0]){
		
		case "select":
			Qiu.say("(=^_^=)[卖萌] Master。秋正在帮你查找您所需的数据");
			Qiu.putAll(query.query(toQuery(orders)));
			break;
			
		case "insert":
			Qiu.say("成功影响了 "+query.executeSql(toQuery(orders))+" 条数据");
			break;
			
		case "update":
			Qiu.say("成功影响了 "+query.executeSql(toQuery(orders))+" 条数据");
			break;
			
		case "delete":
			Qiu.say("成功影响了 "+query.executeSql(toQuery(orders))+" 条数据");
			break;
		case "lookup":
			lookup(orders);
			break;
		case "设置" :
			setting(orders);
			break;
		case "更换数据源":
			Qiu.say("╮(￣▽ ￣)╭  Master，要换个数据库玩儿吗 Orz~");
			DBOpera.connect();
			break;
		case "搜索":
			Qiu.say("Master . 秋 开始搜索 ： ( "+orders[1]+" )啦~");
			Qiu.say("不好意思哈，搜索功能出了点问题，暂时用不了");
//			Search.search(orders);
			search(orders);
			break;
		case "退出":
			Qiu.say("主人再见~ (o^0^o)/~~~~~~~バイバ～イ！！");
			System.exit(0);
			
		default :
			Qiu.say("Oh My Master ,您输的都是什么鬼(つಥ㉨ಥ)つ      :"+OrderDeal.toQuery(orders));
		}
	}
	
	protected static DBConnectPara getDBPara(){
		DBConnectPara dbPara = getDBConnectPara(Qiu.getOrders("Master,请您依次输入 数据库类型，地址，库名，账号，密码。 喵~＞▽＜~"));
		if(dbPara == null){
			log.info("��ݿ����Ӳ����ȡʧ�ܣ����������Ƿ�����");
			return null;
		}
		else{
			return dbPara;
		}
	}
}
