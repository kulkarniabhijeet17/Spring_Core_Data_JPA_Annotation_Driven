package com.springcorejpa;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springcorejpa.config.DataSourceConfig;
import com.springcorejpa.model.UserInfo;
import com.springcorejpa.services.UserService;

public class Application {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(DataSourceConfig.class);
		context.scan("com");
		context.refresh();

		UserService userService = (UserService) context.getBean("userService");

		List<UserInfo> userInfoList = userService.getAllUsers();
		for (UserInfo ui1 : userInfoList) {
			System.out.println("User ID:: " + ui1.getUserID());
			System.out.println("First Name:: " + ui1.getFirstName());
			System.out.println("Last Name:: " + ui1.getLastName());
		}

		UserInfo userInfo = userService.getById("Abhijeet24");

		List<UserInfo> userInfoLst = userService.findByLastName("Kulkarni");

		UserInfo ui = new UserInfo();
		ui.setUserID("Abhijeet24");
		ui.setFirstName("Abhijeet");
		ui.setLastName("Kulkarni");
		ui.setMiddleInitial("R");
		ui.setDob("27/11/1989");
		ui.setEmailID("kulkarniabhijeet17@gmail.com");

		userService.addUser(ui);
		userService.updateUser(ui);

		userService.deleteUser("Abhijeet24");

		context.close();
	}
}