package Pack;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
class UserDao{
	SqlSessionFactory ssf;
	
	
	public UserDao() {
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			ssf = new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void insert(int num) {
		SqlSession session = ssf.openSession();
		try {
			int result = session.insert("test01",num);
			if(result > 0) session.commit();
			
		} catch (Exception e) { e.printStackTrace();
		}finally { session.close(); }
		System.out.println("insert success");
		
	}
	
	void showAge() {
		SqlSession session = ssf.openSession();
		List<Integer> mm = session.selectList("test04");
		for (Integer item : mm) {
			System.out.print(item + " ");
		}System.out.println();
		
		session.close();
		System.out.println("select success");
	}
	
	void update(int num) {
		SqlSession session = ssf.openSession();
		try {
			int result = session.update("test03",num);
			if(result > 0) session.commit();
			
		} catch (Exception e) { e.printStackTrace();
		}finally { session.close(); }
		System.out.println("update success");
		
	}
	
	void delete(int num) {
		SqlSession session = ssf.openSession();
		try {
			int result = session.delete("test02",num);
			if(result > 0) session.commit();
		} catch (Exception e) { e.printStackTrace();
		}finally { session.close(); }
		System.out.println("delete success");	
	}
}
public class Hello{
	public static void main(String[] args) {
		UserDao dao = new UserDao();
//		dao.insert(6666);
		dao.showAge();
//		dao.update(2222);
//		dao.delete(7777);
	}
}

/*
public class Hello {
	public static void main(String[] args) {
		
		SqlSessionFactory ssf = null;
		SqlSession session = null;
		
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ssf = new SqlSessionFactoryBuilder().build(is);
		
		session = ssf.openSession();
		
		try {
			//int result = session.insert("test02", 9999);
			//int result = session.delete("test03", 9999);
			//int result = session.update("test04", 7777);
			//if(result >0 ) session.commit();

			List<Integer> mm = session.selectList("test01");
			for(Integer item : mm) {
				System.out.println(item + " ");
			}System.out.println();
		}
		catch (Exception e) { e.printStackTrace();}
		finally { session.close();}
		
	}
}
*/

	