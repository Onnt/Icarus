package db.gate;

import java.util.List;
import java.util.Scanner;

import cn.blacard.console.xiaoqiu.Qiu;
import cn.blacard.dbopera.entity.SearchResultEntity;
import cn.blacard.nymph.file.out.TextOut;
import db.plugs.constant.OperaOfSearchConstant;
import db.service.impl.OperaOfSearch;

public class Search {
	private static TextOut textOut = null;
	
	private static int percent = 100;
	

	private static OperaOfSearch opera = null;
	
	public static void search(String[] orders){

		textOut = new TextOut("F://sunao.txt");
		
				opera = new OperaOfSearch();
				Qiu.say("开始搜索数据，文档保存在 F://sunao.txt中");
				opera.runSearch(orders[1]);
				
		
				new Thread(){
					public void run() {
						while(true){
							try {
								Thread.sleep(1000);
								List<SearchResultEntity> list = opera.getNewList();
								output(list);
								percent = opera.getTablePercent();
								System.out.println("进度:"+percent+"%");
								if(opera.getStatus()==OperaOfSearchConstant.DONE){
									break;
								}
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					};
				}.start();
		
	}
	
	public static void output(List<SearchResultEntity> list){
		if(list!=null){
			for(SearchResultEntity sre : list){
				textOut.put("==============================");
				System.out.println("==========================");
				System.out.println("表名"+sre.getTableName());
				textOut.put("tableName:"+sre.getTableName());
				textOut.put("================================");
				System.out.println("==========================");
				for(List<String> l : sre.getList()){
					StringBuffer sb = new StringBuffer();
					for(String str : l){
						sb.append(str+"  ");
						System.out.print(str);
						System.out.print("\t");
					}
					System.out.println("");
					textOut.put(sb.toString());
				}
			}
		}
	}
}
