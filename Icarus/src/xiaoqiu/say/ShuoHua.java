package xiaoqiu.say;

/**
 * ���ðٶ���������APi 
 * ��ȡ��ʹ�õĵ�������
 * @author Administrator
 *
 */
public class ShuoHua {
//	private RestApi ra = new RestApi();
	
	/**
	 * �����������һ������ɵ�AccessToken
	 * ����ԥ��Ҫ��Ҫ��API Key��Secret Keyд��
	 * ��д���ɡ����ڿ����Ż�
	 * @return  ����ɵ�Token���о�������˷Ѱ���ÿ����һ�ξ�Ҫ���һ���µ�token
	 * �Ժ��п����Ż���
	 */
//	public  String  getNewAccessToken(){
//		String baidu ="https://openapi.baidu.com/oauth/2.0/token?";
//		String grant_type = "grant_type=client_credentials";
//		String client_id = "&client_id=yMOZ0v2ANY6UF0l6CNfVnVae";
//		String client_secret = "&client_secret=4FES0YBC79G9tkSHOjR23r84c2zR47mV";
//		String json = ra.getData(baidu+grant_type+client_id+client_secret);
//		//�����ȡ��д���ģ���һ���ȱ仯�ͻ����
//		json = json.substring(17, 86);
//		return json;
//	}
}


//		��ȡAccess Token
//		https://openapi.baidu.com/oauth/2.0/token?
//		grant_type=client_credentials&
//		client_id=yMOZ0v2ANY6UF0l6CNfVnVae&
//		client_secret=4FES0YBC79G9tkSHOjR23r84c2zR47mV
//		
//		24.ad38f510c074de5af548f81d0901887f.2592000.1465201180.282335-7691602
//		{"access_token":"24.001c91b8e6116c5e07d6518604e5b98c.2592000.1465197210.282335-7691602",
//			"session_key":
//				"9mzdCyjA9\/62wxi35qbQjj\/iOOGmv2LipanBWHLmLcfjWv2yQnEd7HvOWKhNZuhDXAMABtsrpa5ynhpgWRovIYUxT9me","scope":"public audio_tts_post wise_adapt lebo_resource_base lightservice_public hetu_basic lightcms_map_poi kaidian_kaidian","refresh_token":"25.cbeefe35898d6c2b358a37ff50a0d7cf.315360000.1777965210.282335-7691602","session_secret":"894ba579760b9bba4038b26c0b1c97e9","expires_in":2592000}
//		
//		
//		�������
//		http://tsn.baidu.com/text2audio?lan=zh&cuid=234234&ctp=1&tok=24.704ca8237f9763d71e16e0d794bd5814.2592000.1467188971.282335-7691602&tex=����������