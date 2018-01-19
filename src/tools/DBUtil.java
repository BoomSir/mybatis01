package tools;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtil {
	static SqlSessionFactory sqlSessionFactory;
	static {
		String resource = "mybatis-config.xml";
		InputStream inputStream =null;
		//构建输入流
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
	}
	public static SqlSessionFactory findSqlSessionFactory() {
		return sqlSessionFactory;
	}
	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		//构建输入流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		System.out.println(sqlSessionFactory);
		SqlSession session = sqlSessionFactory.openSession();
	}
}
