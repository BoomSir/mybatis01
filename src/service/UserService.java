package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.User;
import tools.DBUtil;

public class UserService {
	SqlSessionFactory sqlSessionFactory;
	public UserService() {
		sqlSessionFactory = DBUtil.findSqlSessionFactory();
	}
	
	
	public User selectById(Integer id) {
		SqlSession session = sqlSessionFactory.openSession();
		User user=null;
		try {
			user = session.selectOne("mapper.UserMapper.selectById", id);
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
			users = session.selectList("mapper.UserMapper.selectAll");
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
			session.insert("mapper.UserMapper.insert", user);
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
			session.delete("mapper.UserMapper.delete", id);
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
			session.update("mapper.UserMapper.update", user);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
	}
}
