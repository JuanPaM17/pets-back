package com.spring.pets.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Configuration
public class EncrypToData {

	// --- Only Password Encrypt

	public static String encryptPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}

	public static boolean verifyPassword(String originalPassword, String haspwPassword) {
		return BCrypt.checkpw(originalPassword, haspwPassword);
	}

	public static void main(String[] args) throws Exception {
		// Example password
		String passwordEncript = EncrypToData.encryptPassword("santi");
		System.out.println("Contraseña encript: " + passwordEncript);
	}

}
