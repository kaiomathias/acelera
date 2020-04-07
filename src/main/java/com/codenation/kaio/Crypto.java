package com.codenation.kaio;

import org.apache.commons.codec.digest.DigestUtils;


public class Crypto {
	
	public  String cryptoResume(String msg) {
		System.out.println("Chave SHA1 gerada com sucesso!");
		return DigestUtils.sha1Hex(msg);
		
		
	}

}
