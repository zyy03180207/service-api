package microservice.api;

import java.util.Map;

public interface ServiceApi {
	
	/**
	 * 业务处理成功
	 */
	public static String CODE_SUCC ="S";
	/**
	 * 业务处理失败
	 */
	public static String CODE_FAIL ="F";
	
	
	public static String HMAC ="hmac";
	public static String DATA ="data";
	public static String CMMD ="cmmd";
	

	public static String RET_CODE ="retCode";
	public static String RET_MESG ="retMesg";
	
	
	

	/**
	 * @deprecated 
	 * @param map
	 * @return
	 */
	public Map<String,String> handler(Map<String,String> map);
	
	
	/**
	 * @param param
	 * @return
	 */
	public String execute(String json);

	
	public String getApiInfo();
	
	

}
