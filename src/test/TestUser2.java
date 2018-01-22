package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.User;
import service.UserService2;

public class TestUser2 {
	UserService2 ser;
	@Before
	public void Init() {
		ser=new UserService2();
	}
	
	@Test
	public void selectById() {
		User user = ser.selectById(1);
		System.out.println(user.getUsername()+","+user.getPassword());
	}
	@Test
	public void selectAll() {
		List<User> users = ser.selectAll();
		System.out.println(users);
	}
	@Test
	public void insert() {
		User user=new User();
		user.setId(10);
		user.setUsername("张三");
		user.setPassword("1234");
		user.setPhone("222222");
		ser.save(user);
	}
	@Test
	public void update() {
		User user=new User();
		user.setId(10);
		user.setUsername("张三");
		user.setPassword("1234");
		user.setPhone("5453");
		ser.modify(user);
	}
	@Test
	public void delete() {
		ser.remove(10);
	}
	@Test
	public void selectByLike() {
		User user=new User();
		user.setUsername("j");
		List<User> users=ser.findByLike(user);
		System.out.println(users);
	}
}
