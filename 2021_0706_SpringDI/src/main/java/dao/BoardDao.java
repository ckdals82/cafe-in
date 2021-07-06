package dao;

import java.util.List;

public interface BoardDao {
	
	List selectList();
	int insert(Object ob);
	int update(Object ob);
	int delete(int idx);
	
}


