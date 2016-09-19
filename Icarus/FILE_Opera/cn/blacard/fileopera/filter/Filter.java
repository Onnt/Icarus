package cn.blacard.fileopera.filter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.blacard.nymph.file.NymFile;

public class Filter {
	/**
	 * 根据大小筛选文件
	 * isLesser 为true，返回小于size的文件。
	 * 否则，返回比size大的文件
	 * @author Blacard
	 * @create 2016年9月19日 下午2:11:49
	 * @param isLesser 决定筛选小于size还是大于size的文件
	 * @param path 要筛选文件的根目录
	 * @param size 基础值，筛选的文件比这个数大。或是小
	 * @return 
	 */
	public List<File> filterBySize(boolean isLesser,String path,String size){
		NymFile nymFile = new NymFile(path);
		long base = NymFormat.parseLong(size);
		List<File> list = nymFile.getAllFiles();
		List<File> greaterList = new ArrayList<File>();
		List<File> lesserList = new ArrayList<File>();
		for(File f : list){
			if(f.length()>base)
				greaterList.add(f);
			else
				lesserList.add(f);
		}
		return isLesser?lesserList:greaterList;
	}
}


//以后就删掉吧，
class NymFormat{

	/**
	 * 将以数字加单位形式的文件大小转换成具体数字
	 * 例：“3.3MB” 转换为 “3460300” 
	 * 目前仅支持 KB,MB,GB 单位的转换
	 * @author Blacard
	 * @create 2016年9月19日 上午11:42:32
	 * @param str 数字加单位形式表示的文件大小
	 * @return 转换后的纯数字文件大小
	 */
	public static long parseLong(String str){
		//获取到参数的数字部分
		float n = Float.parseFloat(str.substring(0,str.length()-2));
		//获取到参数的单位部分
		String unit = str.substring(str.length()-2,str.length());
		//定义返回结果
		long result = 0;
		//将参数的数字部分转换成long类型，乘1000是防止丢失小数部分
		long  num = (long)(n*1000);
		switch(unit.toUpperCase()){
		case "KB":
			result = 1024*num;
			break;
		case "MB":
			result = 1024*1024*num;
			break;
		case "GB":
			result =  1024*1024*1024*num;
			break;
		}
		//将上面的1000还回去
		result = result/1000;
		return result;
	}
}