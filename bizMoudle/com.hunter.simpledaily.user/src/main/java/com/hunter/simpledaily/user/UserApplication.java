package com.hunter.simpledaily.user;

import com.hunter.base.common.enumerate.DataState;
import com.hunter.base.common.utils.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
		DataState dataState = DataState.DRAFT;
		System.out.println("======启动完成======" + StringUtils.equals("2","3"));
	}

}
