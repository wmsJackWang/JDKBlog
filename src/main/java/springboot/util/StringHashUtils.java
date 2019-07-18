package springboot.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringHashUtils {

	 public static String md5(String data) throws NoSuchAlgorithmException {  
	        MessageDigest md = MessageDigest.getInstance("MD5");  
	        md.update(data.getBytes());  
	        StringBuffer buf = new StringBuffer();  
	        byte[] bits = md.digest();  
	        for(int i=0;i<bits.length;i++){  
	            int a = bits[i];  
	            if(a<0) a+=256;  
	            if(a<16) buf.append("0");  
	            buf.append(Integer.toHexString(a));  
	        }  
	        return buf.toString();  
	    }  
	      
	    public static String sha1(String data) throws NoSuchAlgorithmException {  
	        MessageDigest md = MessageDigest.getInstance("SHA1");  
	        md.update(data.getBytes());  
	        StringBuffer buf = new StringBuffer();  
	        byte[] bits = md.digest();  
	        for(int i=0;i<bits.length;i++){  
	            int a = bits[i];  
	            if(a<0) a+=256;  
	            if(a<16) buf.append("0");  
	            buf.append(Integer.toHexString(a));  
	        }  
	        return buf.toString();  
	    }  
	      
	    public static void main(String[] args) throws NoSuchAlgorithmException{  
//	        String data = "update SW_GATEWAY_RECORD set  MERCHANT_NAME = '����'   where MERCHANT_ID = 8000;";  
//	        String data1 = "update SW_GATEWAY_RECORD set  MERCHANT_NAME = '����'   where MERCHANT_ID = 8000;";
	        //MD5  
	        System.out.println("MD5 hello : hashcode : "+"hello".hashCode()+"  "+md5("hello")+" MD5后 hashcode:"+md5("hello").hashCode());  
	        System.out.println("MD5 hella : hashcode : "+"hella".hashCode()+"  "+md5("hella")+"  MD5后 hashcode:"+md5("hella").hashCode());
	        //SHA1  
	        System.out.println("SHA1 hello : hashcode : "+"hello".hashCode()+"  "+sha1("hello")+" MD5后   hashcode:"+sha1("hello").hashCode());  
	        System.out.println("SHA1 hella : hashcode : "+"hella".hashCode()+"  "+sha1("hella")+"  MD5后  hashcode:"+sha1("hella").hashCode());  
	        System.out.println("经过字符串 指纹处理后，hashcode的值都不接近了，能做到特别的分散");
	    }  
}
