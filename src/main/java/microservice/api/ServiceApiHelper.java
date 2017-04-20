package microservice.api;

import java.net.InetAddress;

import com.alibaba.fastjson.JSONObject;

public class ServiceApiHelper {
	public static String md5(String str) {
		return ServiceApiAdapter.md5(str);
	}
	public static String encode(String key,String data){
		return ServiceApiAdapter.encode(key, data);
	}
	public static String decode(String key,String data){
		return ServiceApiAdapter.decode(key, data);
	}
	public static String formatParam(String cmmd,String dataJson,String key){
		JSONObject param = new JSONObject();
		param.put(ServiceApi.CMMD, cmmd);
		param.put(ServiceApi.DATA, dataJson);
		param.put(ServiceApi.HMAC, md5(dataJson+key));
		return param.toJSONString();
	}
	public static void main(String[] args) {
		JSONObject j = new JSONObject();
		j.put("a", 1);
		j.put("b", 2);
	}
	public static ServiceParam parseParam(String json){
		return JSONObject.parseObject(json, ServiceParam.class);

	}
	public static ServiceResult parseResult(String json){
		return JSONObject.parseObject(json, ServiceResult.class);
	}
	public static ServiceResult parseResult(String json,String key){
		ServiceResult result = JSONObject.parseObject(json, ServiceResult.class);
		if(result != null && result.isSucc()){
			String hmac1 = ServiceApiHelper.md5(result.getData()+key);
			String hmac2 = result.getHmac();
			if(!hmac1.equals(hmac2)){
				result = new ServiceResult();
				result.setSucc(false);
				result.setMesg("验证返回签名失败");
				return result;
			}
		}
		return result;
	}
	
	public static String getHostHame() {
		try {  
            return (InetAddress.getLocalHost()).getHostName();  
        } catch (Exception uhe) {  
            String host = uhe.getMessage();
            if (host != null) {  
                int colon = host.indexOf(':');  
                if (colon > 0) {  
                    return host.substring(0, colon);  
                }  
            }  
            return "unknown";  
        } 
	}
}
