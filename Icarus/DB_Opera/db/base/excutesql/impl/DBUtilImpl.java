package db.base.excutesql.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.blacard.dbopera.opera.OperaBase;

/**
 * ������ǵײ���Ψһ��¶�������
 * 
 * �����еײ�������
 * 
 * @author Blacard
 *
 */
public class DBUtilImpl extends OperaBase{


	public int getRowCount(String table){
		openConnect();
		try {
			rs = sta.executeQuery("select count(*) as row from "+table);
	        rs.next();
	        return rs.getInt("row");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeConnect();
		}
        return -1;
	}
	public ResultSet queryRes(String sql) {
		openConnect();
		try {
			return sta.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeConnect();
		}
		return null;
	}
}
