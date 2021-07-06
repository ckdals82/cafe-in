package dao;

import java.util.ArrayList;
import java.util.List;

public class BoardDaoImpl implements BoardDao {

	@Override
	public List selectList() {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		
		list.add("안녕하세요");
		list.add("Hi Everyone");
		list.add("오겡끼데스");
		list.add("니하오");
		list.add("니뽕내뽕");
		list.add("오하요");
		
		return list;
	}

	@Override
	public int insert(Object ob) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Object ob) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int idx) {
		// TODO Auto-generated method stub
		return 0;
	}

}
