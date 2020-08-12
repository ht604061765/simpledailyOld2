package com.hunter.base.framework.utils;

import com.hunter.simpledaily.user.UserVo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
		UserVo userVo = new UserVo();
		userVo.setUserName("123456");

		System.out.println("======启动完成======" + userVo.getUserName());
	}

}
