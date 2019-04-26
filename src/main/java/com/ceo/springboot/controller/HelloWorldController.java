package ceo.springboot.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ceo.springboot.Ceoproperties;
import ceo.springboot.dao.UserRepository;
import ceo.springboot.domain.User;
import ceo.springboot.service.UserService;

@RestController
public class HelloWorldController {
	
	@Autowired
	private UserService service;
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private Ceoproperties pro;
	
//	public static void main(String[] args) {
//		
//	}
	
	@RequestMapping(value="/searchUser.action")
	public String demo2(@RequestParam(value="id",required=false) String id){
		if(id!=null&&id!=""){
			//		User user =userRepository.findBylid(Long.parseLong(id));
			User user1 =userRepository.findOne(Long.parseLong(id));
			if(user1==null){
				return "查找不到id为"+id+"的记录哦  嘤嘤嘤~~~";
			}else{
				System.out.println(user1.toString());
				return user1.toString();
			}
		}
		return "请传入参数id查找用户";
	}
	
	@RequestMapping(value="addUser.action")
	public void adduser(@RequestParam(value="username") String username){
		User user =new User();
		user.setName(username);
		user.setUsername(username);
		user.setAddress("广州市天河区科华街351号");
		user.setAge(24);
		user.setPassword("123456");
		user.setSex("1");
		userRepository.save(user);
	}
	@RequestMapping(value="updateUser.action")
	public void updateuser(@RequestParam(value="id") String lid,@RequestParam(value="name") String username){
		userRepository.updateById(username, lid);
		User user =userRepository.findBylid(Long.parseLong(lid));
		System.out.println(user);
	}
	
	
	@RequestMapping("/hello.action")
	public String demo1(HttpServletRequest req,@RequestParam(required=false,value="name") String name){
		User user =service.getUser(name);
		System.out.println(pro.getTitle());
		System.out.println(pro.getDescription());
		return "user";
	}
}
