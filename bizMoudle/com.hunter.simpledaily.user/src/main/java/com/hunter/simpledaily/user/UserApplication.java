package com.hunter.simpledaily.user;

import com.hunter.base.framework.utils.TestVo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
		TestVo testVo = new TestVo();
		testVo.setAttr1("123adsg");

		System.out.println("======启动完成======" + testVo.getAttr1());
	}

}
