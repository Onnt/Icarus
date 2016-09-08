package cn.blacard.console.DB_Opera;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import cn.blacard.console.xiaoqiu.Qiu;
import cn.blacard.dbopera.Setting;
import cn.blacard.dbopera.entity.SearchResultEntity;
import cn.blacard.dbopera.opera.DBInfoQuery;
import cn.blacard.dbopera.opera.Query;
import cn.blacard.dbopera.opera.search.SearchOpera;
import cn.blacard.dbopera.para.DBConnectPara;

public class OrderDeal {
	
	private static Logger log = Logger.getLogger(OrderDeal.class.getName());
	
	private static DBInfoQuery dbi = new DBInfoQuery();
	

	private static Query query = new Query();
	
	public static DBConnectPara getDBConnectPara(String[] paras){
		
		DBConnectPara dbPara = new DBConnectPara();
		
		if(paras == null || paras.length != 5){
			log.info("数据库连接参数为空 或者 参数数量错误");
			return null;
		}
		
		dbPara.setStyle(paras[0]);
		dbPara.setIp(paras[1]);
		dbPara.setDbName(paras[2]);
		dbPara.setUser(paras[3]);
		dbPara.setPass(paras[4]);
		
		return dbPara;
	}
	
	public static String toQuery(String[] orders){
		StringBuffer sb= new StringBuffer();
		
		for(String s : orders){
			sb.append(s+" ");
		}

		return sb.toString();
	}
	
	
	protected static void lookup(String[] orders){
		switch(orders[1]){
		case "all_tables" :

			List<String> list =  dbi.getAllTableNames();
			for(int i = 0 ; i < list.size() ; i++){
				if(i != 0 && i%5 == 0){
					System.out.println(list.get(i));
				}else{
					System.out.print(list.get(i)+"\t");
				}
			}
			
			break;
		case "table":
			Qiu.putAll(dbi.getTableColumns(orders[2]));
			break;
		default : log.info("what are you want to do?");
		}
	}
	
	protected static void setting(String[] orders){
		switch(orders[1]){
		case "日志" : 
			Setting.setLogOutPath(orders[2]);
			Qiu.say("日志输出位置设置成功！当前位置为： "+orders[2]);
			break;
		case "查看" :
			Qiu.out("\t日志输出位置："+Setting.getLogOutPath());
			break;
		default : ;
		}
	}
	
	protected static void search(String[] orders){
		String search = orders[1];
		List<String> list = dbi.getAllTableNames();
		for(String table : list){
			Qiu.out("开始搜索表："+table);
			new TableSearchThread(table,search).start();
		}
		Qiu.say("报告Master！表搜索线程启动完毕！后台程序正在搜索，你可以去日志查看结果");
	}
	
}

class TableSearchThread extends Thread{
	private Query query = new Query();
	private String table;
	private String search;
	public TableSearchThread(String table,String search){
		this.table = table;
		this.search = search;
	}
	@Override
	public void run() {
		SearchResultEntity sre = new SearchResultEntity();
		sre.setTableName(table);
		List<List<String>> result_list_list = new ArrayList<List<String>>();
		
		List<List<String>> list_list = query.query("select * from "+ table);
		
		for(int i = 0 ; i < list_list.size() ; i++){
			for(int j = 0 ; j < list_list.get(i).size(); j++){
				if(list_list.get(i).get(j) != null 
						&&
					list_list.get(i).get(j).contains(search))
				{
					result_list_list.add(list_list.get(i));
					Qiu.putToTxt("表名："+table);
					Qiu.putToTxt(list_list.get(i));
					continue;
				}
			}
		}
	}
	
}
