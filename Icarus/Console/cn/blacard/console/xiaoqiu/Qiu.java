package cn.blacard.console.xiaoqiu;

import java.util.List;

import cn.blacard.dbopera.Setting;
import cn.blacard.nymph.inputAndOutput.MasterInput;
import cn.blacard.nymph.text.TextOut;
/**
 * 
 * @author Blacard
 * @联系方式 邮箱：blacard@163.com <br/> 手机：18037170703
 * @create 2016年9月19日 下午3:02:56
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
		say(QIUSTRING.PLEASE_ORDER_ME);
		return MasterInput.getMasterInputs();
	}
	public static String[] getOrders(String alert){
		say(alert);
		return MasterInput.getMasterInputs();
	}
}
