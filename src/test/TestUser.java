package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.User;
import service.UserService;

public class TestUser {
	UserService ser;
	@Before
	public void Init() {
		ser=new UserService();
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
}
