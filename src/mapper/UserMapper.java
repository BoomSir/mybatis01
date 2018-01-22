package mapper;

import java.util.List;

import model.User;

public interface UserMapper {
	User selectById(Integer id);
	List<User> selectAll();
	public void insert(User user);
	public void delete(Integer id);
	public void update(User user);
	List<User> selectByLike(User user);
}
