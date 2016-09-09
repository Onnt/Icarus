package cn.blacard.console.xiaoqiu;

import java.util.List;

import cn.blacard.dbopera.Setting;
import cn.blacard.nymph.inputAndOutput.MasterInput;
import cn.blacard.nymph.text.TextOut;

/**
@author  Blacard
���䣺blacard@163.com
@date ����ʱ�䣺2016��7��29�� ����2:23:50 
  */
public class Qiu {
	
	public static void say(String word){
		System.out.println("小秋："+word);
		new TextOut(Setting.getLogOutPath()).putln("小秋："+word);
	}
	public static void out(String word){
		System.out.println(word);
		new TextOut(Setting.getLogOutPath()).putln("小秋："+word);
	}
	
	public static void putToTxt(String word){
		new TextOut(Setting.getLogOutPath()).putln(word);
	}

	public static void putToTxt(List<String> list){
		StringBuffer sb = new StringBuffer();
		for(String s : list){
			sb.append(s+"\t");
		}
		putToTxt(sb.toString());
	}
	public static void out(List<String> list){
		StringBuffer sb = new StringBuffer();
		for(String s : list){
			sb.append(s+"\t");
		}
		out(sb.toString());
	}
	
	public static void putAll(List<List<String>> list_list){
		
		if(list_list == null|| list_list.size() == 0){
			say("主人，什么都没有~  so sad ~");
			return;
		}
		
		
		for(List<String> list : list_list){
			StringBuffer sb = new StringBuffer();
			for(String s : list){
				sb.append(s+"\t");
			}
			out(sb.toString());
		}
	}
	
	
	public static String[] getOrders(){
		say("请主人命令我做些什么事情吧~ 喵~＞▽＜");
		return MasterInput.getMasterInputs();
	}
	public static String[] getOrders(String alert){
		say(alert);
		return MasterInput.getMasterInputs();
	}
}
