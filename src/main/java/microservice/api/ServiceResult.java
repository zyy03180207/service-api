package microservice.api;

import java.io.Serializable;

public class ServiceResult implements Serializable{
	private static final long serialVersionUID = 1L;
	private boolean succ = false;
	private String code = "";
	private String mesg = "";
	private String data = "";
	private String hmac = "";
	
	
	public static ServiceResult createFailResult(String mesg){
		ServiceResult  result = new ServiceResult();
		result.setCode(ServiceApi.CODE_FAIL);
		result.setMesg(mesg);
		return result;
	}
	
	public boolean isSucc() {
		return succ;
	}
	public void setSucc(boolean succ) {
		this.succ = succ;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMesg() {
		return mesg;
	}
	public void setMesg(String mesg) {
		this.mesg = mesg;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHmac() {
		return hmac;
	}
	public void setHmac(String hmac) {
		this.hmac = hmac;
	}


	@Override
	public String toString() {
		return "ServiceResult [succ=" + succ + ", code=" + code + ", mesg="
				+ mesg + ", data=" + data + ", hmac=" + hmac + "]";
	}
	
	
	
}



