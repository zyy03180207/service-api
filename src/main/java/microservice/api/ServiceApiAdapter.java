package microservice.api;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.alibaba.fastjson.JSONObject;

public class ServiceApiAdapter implements ServiceApi{
	
	public Map<String, String> handler(Map<String, String> map) {
		Map<String,String> ret = new HashMap<String,String>();
		ret.put(RET_CODE, CODE_FAIL);
		ret.put(RET_MESG, "接口未实现");
		return ret;
	}
	
	public String execute(String param){
		return JSONObject.toJSONString(ServiceResult.createFailResult("接口未实现"));
	}


	public String getApiInfo() {
		return "接口未实现";
	}
	
	
	public static Map<String,String> setFailValue(String mesgValue, Map<String,String> map){
		map.put(RET_CODE, CODE_FAIL);
		map.put(RET_MESG, mesgValue);
		return map;
	}
	
	public static Map<String,String> setSuccData(String dataValue, Map<String,String> map){
		map.put(RET_CODE, CODE_SUCC);
		map.put(RET_MESG, "成功");
		map.put(RET_MESG, dataValue);
		return map;
	}
	
	
	public static String encode(String key,String data){
		try{
			return toHex(des3Encryption(key.getBytes(), data.getBytes()));
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	
	public static String decode(String key,String data){
		try{
			return  new String(des3Decryption(key.getBytes(), fromHex(data)),"UTF-8");
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	
	private static byte[] des3Decryption(byte[] key, byte[] data) throws
	    NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException,
	    BadPaddingException, IllegalBlockSizeException, IllegalStateException {
	  final String Algorithm = "DESede";
	
	  SecretKey deskey = new SecretKeySpec(key, Algorithm);
	
	  Cipher c1 = Cipher.getInstance(Algorithm);
	  c1.init(Cipher.DECRYPT_MODE, deskey);
	  return c1.doFinal(data);
	}
	
	private static byte[] des3Encryption(byte[] key, byte[] data) throws
	    NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException,
	    BadPaddingException, IllegalBlockSizeException, IllegalStateException {
	  final String Algorithm = "DESede";
	
	  SecretKey deskey = new SecretKeySpec(key, Algorithm);
	
	  Cipher c1 = Cipher.getInstance(Algorithm);
	  c1.init(Cipher.ENCRYPT_MODE, deskey);
	  return c1.doFinal(data);
	}
	
	private static String toHex(byte input[]){
        if(input == null)
            return null;
        StringBuffer output = new StringBuffer(input.length * 2);
        for(int i = 0; i < input.length; i++){
            int current = input[i] & 0xff;
            if(current < 16)
                output.append("0");
            output.append(Integer.toString(current, 16));
        }

        return output.toString();
    }

	private static byte[] fromHex(String input){
        if(input == null)
            return null;
        byte output[] = new byte[input.length() / 2];
        for(int i = 0; i < output.length; i++)
            output[i] = (byte)Integer.parseInt(input.substring(i * 2, (i + 1) * 2), 16);

        return output;
    }
	public static String md5(String str) {
		try {
			byte[] data = str.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("MD5");
			return toHex(md.digest(data));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
