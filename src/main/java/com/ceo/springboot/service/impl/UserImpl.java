package ceo.springboot.service.impl;

import org.springframework.stereotype.Service;

import ceo.springboot.domain.User;
import ceo.springboot.service.UserService;

@Service
public class UserImpl implements UserService {

	@Override
	public User getUser(String name) {
		User u =new User();
		u.setAddress("广州市天河区科华街351号");
		u.setAge(22);
		u.setName(name);
		u.setSex("男");
		return u;
	}

}
