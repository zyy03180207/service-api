package microservice.api;

import java.io.Serializable;

public class ServiceParam implements Serializable{
	private static final long serialVersionUID = 1L;
	private String data;
	private String hmac;
	private String cmmd;
	
	public ServiceParam(){
		
	}
	public ServiceParam(String data, String hmac, String cmmd) {
		super();
		this.data = data;
		this.hmac = hmac;
		this.cmmd = cmmd;
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
	public String getCmmd() {
		return cmmd;
	}
	public void setCmmd(String cmmd) {
		this.cmmd = cmmd;
	}
	
}
