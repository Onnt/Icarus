package cn.blacard.dbopera.entity;

import java.util.List;

public class SearchResultEntity {
	private String tableName;
	private List<List<String>> list;
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public List<List<String>> getList() {
		return list;
	}
	public void setList(List<List<String>> list) {
		this.list = list;
	}
	public SearchResultEntity(String tableName, List<List<String>> list) {
		super();
		this.tableName = tableName;
		this.list = list;
	}
	public SearchResultEntity() {
		super();
	}
	
	
	
}
