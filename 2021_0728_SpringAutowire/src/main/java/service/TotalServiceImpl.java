package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.DeptDao;
import vo.DeptVo;

public class TotalServiceImpl implements TotalService {
	
	@Autowired
	DeptDao dept_dao;
	
	@Override
	public List<DeptVo> selectDeptList() {
		// TODO Auto-generated method stub
		return dept_dao.selectList();
	}

}
