package common.encrypt;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class EcyptPassword {

	
	public static String getSha512(String password)
	{
		String encPwd="";
		//sha512방식의 암호화 객체 생성
		MessageDigest md=null;
		
		try 
		{
			md=MessageDigest.getInstance("SHA-512");
		}
		catch(NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		byte[] bytes=password.getBytes(Charset.forName("UTF-8"));
		
		md.update(bytes);//알고리즘 돌리기~! 
		
		encPwd=Base64.getEncoder().encodeToString(md.digest());
		
		return encPwd;		
		
	}
	
}
