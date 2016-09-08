package cn.blacard.dbopera.opera.search;

import java.util.ArrayList;
import java.util.List;

import cn.blacard.dbopera.entity.SearchResultEntity;
import cn.blacard.dbopera.opera.Query;

/**
 * 搜索功能，只适用于控制台
 * @author Blacard
 *
 */
public class SearchOpera {
//getAllTables
// start thread
//search
	


	private String tableName;
	private String search;
	private Query query = new Query();
	
	public SearchOpera(String tableName,String search){
		this.tableName = tableName;
		this.search = search;
	}
	/**
	 * 没有考虑大批量数据的搜索
	 * @return
	 */
	public SearchResultEntity lookupTable(){
		SearchResultEntity sre = new SearchResultEntity();
		sre.setTableName(tableName);
		List<List<String>> result_list_list = new ArrayList<List<String>>();
		
		List<List<String>> list_list = query.query("select * from "+ tableName);
		
		for(int i = 0 ; i < list_list.size() ; i++){
			for(int j = 0 ; j < list_list.get(i).size(); j++){
				if(list_list.get(i).get(j).contains(search)){
					result_list_list.add(list_list.get(i));
					continue;
				}
			}
		}
		if(result_list_list.size() == 0){
			return null;
		}else{
			sre.setList(result_list_list);
			return sre;
		}
	}
	
}
