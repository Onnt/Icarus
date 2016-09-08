package cn.blacard.console.DB_Opera;

import java.sql.Connection;

import cn.blacard.console.xiaoqiu.Qiu;
import cn.blacard.dbopera.connect.Connect;
import cn.blacard.dbopera.para.DBConnectPara;

public class DBOpera {
	

	//数据库连接参数
	private static DBConnectPara para;
	
	public static void start() {
		
		connect();
			
		while(true){
			String[] orders = Qiu.getOrders();
			Order.deal(orders);
		}
	}
	
	public static void connect(){
		//数据库连接
		para = Order.getDBPara();
		
		Connect.setConnPara(para);
		
		Connection conn = Connect.getConn();	
		
		if(conn!=null){
			Qiu.say("o(*￣▽￣*)ブ，数据库连接成功,可以开始检索数据啦");
			Connect.closeAll(null,null,conn);
		}else{

			Qiu.say("(；′⌒`) 数据库连接失败 ,重新连接吧Master");
			connect();
		}
	} 
}
