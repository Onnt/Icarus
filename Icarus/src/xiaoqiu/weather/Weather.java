package xiaoqiu.weather;

import java.io.IOException;

import net.sf.json.JSONObject;
import cn.blacard.nymph.net.html.HtmlGet;

public class Weather {
	private String result;
	public Weather() throws IOException{
		result = new HtmlGet().getData("https://api.caiyunapp.com/v2/=1yScNbEm4R2rhE-/121.483,31.2333/forecast.json");
	}
	public Weather(String jingdu,String weidu) throws IOException{
		result = new HtmlGet().getData("https://api.caiyunapp.com/v2/=1yScNbEm4R2rhE-/"+jingdu+","+weidu+"/forecast.json");
	}
	public String getDescript(){
		JSONObject jo = JSONObject.fromObject(result);
		JSONObject joj = jo.getJSONObject("");
		String str = jo.getJSONObject("result").getJSONObject("minutely").getString("description");
		return str; 
	}
}  