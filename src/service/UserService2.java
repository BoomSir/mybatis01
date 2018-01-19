package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mapper.UserMapper;
import model.User;
import tools.DBUtil;

public class UserService2 {
	SqlSessionFactory sqlSessionFactory;
	public UserService2() {
		sqlSessionFactory = DBUtil.findSqlSessionFactory();
	}
	
	
	public User selectById(Integer id) {
		SqlSession session = sqlSessionFactory.openSession();
		User user=null;
		try {
			//jdk的动态代理
			UserMapper mapper = session.getMapper(UserMapper.class);
			user = mapper.selectById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return user;
	}
	public List<User> selectAll(){
		SqlSession session = sqlSessionFactory.openSession();
		List<User> users=null;
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			users = mapper.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return users;
	}
	public void save(User user) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			mapper.insert(user);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
	}
	public void remove(Integer id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			mapper.delete(id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
	}
	public void modify(User user) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			mapper.update(user);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
	}
}
