package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import vo.DeptVo;

public class DeptDaoImpl implements DeptDao {
	
	
	//@autowired옵션설정하면 getter/setter안해도된다
	@Autowired
	SqlSession sqlsession;

	@Override
	public List<DeptVo> selectList() {
		// TODO Auto-generated method stub
		return sqlsession.selectList("dept.dept_list");
	}
	

}
