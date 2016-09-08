package cn.blacard.dbopera;

public class Setting {

	//操作 结果输出日志
	private static String logOutPath = "./DataBaseOpera_result_log.txt";

	public static String getLogOutPath() {
		return logOutPath;
	}

	public static void setLogOutPath(String logOutPath) {
		Setting.logOutPath = logOutPath;
	}
	
}
