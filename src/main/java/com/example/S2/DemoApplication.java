package com.example.S2;

import com.example.S2.utils.SecurityUtils;

import java.security.*;

public class DemoApplication {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		KeyPair keyPair = SecurityUtils.generateKeyPair();
		PublicKey publicKey = keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();

		System.out.println("[Server] : publicKey : \n" + publicKey);
		System.out.println("[Server] : privateKey : \n" + privateKey);
	}

}
