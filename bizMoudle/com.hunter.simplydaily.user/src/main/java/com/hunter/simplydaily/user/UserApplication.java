package com.hunter.simplydaily.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
		UserVo userVo = new UserVo();
		userVo.setUserGid("asdf");
		userVo.setUserName("asdf");
		System.out.println("启动完成");
	}

}
