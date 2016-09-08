package db.service.impl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.blacard.dbopera.entity.SearchResultEntity;
import cn.blacard.dbopera.opera.DBInfoQuery;
import db.base.excutesql.impl.DBUtilImpl;
import db.plugs.constant.OperaOfSearchConstant;
/**
 * ���������ݿ�
 * ���кö�ط����Լ����Ż�
 * @author Blacard
 * @since 2016-06-01
 *
 */
public class OperaOfSearch {
	
	private DBInfoQuery dbi = new DBInfoQuery();
	//�������Ĵʣ�ȫ�ֿ���
	private String search;
	//�������Ľ��ļ���
	private List<SearchResultEntity> list = null;
	//�ϴ�list����ȡʱ��size
	private int lastListSize;
	
	//�ײ���ݿ⹤��
	private DBUtilImpl util;
	
	//��������ȣ��������ڱ� �� ������
	private int nowTable ;
	private int countOfTable  ;

	//��������ȣ��������� �� ������
	private int nowRes;
	private int countOfRes;
	
	private int status = OperaOfSearchConstant.READY;
	
	//����ǰ������Ҫ�����ݿ⹤��
	public OperaOfSearch(){
		this.util = new DBUtilImpl();
	}
	/**
	 * ��������ؼ��һ��������
	 * ��󲿷ֶ��������
	 * @param str
	 * @return
	 * @throws SQLException
	 */
	public List<SearchResultEntity> search(String str) throws SQLException{
		this.search = str;
		list = new ArrayList<SearchResultEntity>();
		SearchResultEntity sre = null;
		
		List<String> tables = dbi.getAllTableNames();
		countOfTable = tables.size();
		
		for(String table : tables){
			nowTable++;
			sre = lookupTable(table);
			
			if(!(sre.getList()==null||sre.getList().size()==0)){
				//���sre��list��Ϊ�գ�˵�����������
				//�������add��list
				list.add(sre);
			}
		}
		return list;
	}
	
	/**
	 * ����һ�ű�
	 * @param table
	 * @return
	 * @throws SQLException
	 */
	private SearchResultEntity lookupTable(String table) throws SQLException{
		//����ֵ��ʼ��
		SearchResultEntity sre = new SearchResultEntity();
		sre.setTableName(table);
		List<List<String>> listlist = new ArrayList<List<String>>();
		
		ResultSet res = util.queryRes("select * from "+table);
		
		//�� ��� ����ʼ��Ϊ0 ����ȡ������
		nowRes = 0; countOfRes = 0; 
		countOfRes = util.getRowCount(table);
		
		//��ȡ�������
		ResultSetMetaData rsmd = res.getMetaData();
		int cc = rsmd.getColumnCount();
		
		//��δ����Լ����ɣ�дע��Ҳͦ�鷳��
		boolean isValid = false;
		while(res.next()){
			nowRes++;
			isValid = false;
			List<String> l = null;
			for(int i = 1 ; i <= cc ; i++){
				String s = res.getString(i);
				if(isValid){
					l.add(s);
					continue;
				}
				if(null == s)
					continue;
				if(isValid(s)){
					l = new ArrayList<String>();
					i = 1;
					isValid = true;
				}
			}
			//���l��Ϊnull��˵�����������
			if(l!=null)
				listlist.add(l);
		}
		sre.setList(listlist);
		return sre;
	}

	/**
	 * ��ȡ�����²��ֵ�list
	 * @return
	 */
	public List<SearchResultEntity> getNewList(){
		List<SearchResultEntity> newList = new ArrayList<SearchResultEntity>();
		int size = list.size();
		if(size == lastListSize){
			return null;
		}else{
			for(int i = lastListSize;i<size;i++){
				System.out.println("i:"+i+" list.size:"+size);
				newList.add(list.get(i));
			}
			if(list.size()!=0){
				lastListSize = size;
			}
			return newList;
		}
	}
	/**
	 * �����߳̽�������
	 * @param str
	 */
	public void runSearch(final String str){
		new Thread(){
			public void run(){
				try {
					search(str);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
	}
	private boolean isValid(String str){
		if(str.contains(search))
			return true;
		else
			return false;
	}
	public int getTablePercent(){
		if(countOfTable!=0)
			return (int)(((float)nowTable/(float)countOfTable)*100);
		else if(getStatus() == OperaOfSearchConstant.DONE)
			return 100;
		else
			return 0;
	}
	public int getRowPercent(){
		if(countOfRes!=0)
			return (int)(((float)nowRes/(float)countOfRes)*100);
		else
			return 100;
	}
	public List<SearchResultEntity> getList(){
		return list;
	}
	public int getNowTable() {
		return nowTable;
	}
	public int getCountOfTable() {
		return countOfTable;
	}
	public int getNowRes() {
		return nowRes;
	}
	public int getCountOfRes() {
		return countOfRes;
	}
	public int getStatus() {
		if(status == OperaOfSearchConstant.CONNECT && nowTable == countOfTable)
			status = OperaOfSearchConstant.DONE;
		return status;
	}
	
//	  ResultSet resultSet = statement.executeQuery("select count(*) as rowCount from tableName");
//      resultSet.next();
//      int rowCount = resultSet.getInt("rowCount");
	
}
