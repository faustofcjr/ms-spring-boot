package com.yesiv.oauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yesiv.oauth.entities.User;
import com.yesiv.oauth.feignclients.UserFeignClient;

@Service
public class UserService {

	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserFeignClient userFeignClient;

	public User findByEmail(String email) {
		User user = userFeignClient.findByEmail(email).getBody();

		if (user == null) {
			logger.error("Email not found: ".concat(email));
			throw new IllegalArgumentException("Email not found");
		}

		logger.info("Email found: ".concat(email));
		return user;
	}
}
