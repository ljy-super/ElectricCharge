package com.electricharge;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElectrichargeApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Test
	public void test1(){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update("123".getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
			String a	 = buf.toString();
			System.out.println(a);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}
