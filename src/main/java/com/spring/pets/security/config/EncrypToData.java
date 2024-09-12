package com.spring.pets.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Configuration
public class EncrypToData {

	public static String encryptPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}

	public static boolean verifyPassword(String originalPassword, String haspwPassword) {
		return BCrypt.checkpw(originalPassword, haspwPassword);
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Contraseña secre: " + EncrypToData.encryptPassword("secretario"));
		System.out.println("Contraseña vete: " + EncrypToData.encryptPassword("veterinario"));
		System.out.println("Contraseña admin: " + EncrypToData.encryptPassword("admin"));
	}

}
