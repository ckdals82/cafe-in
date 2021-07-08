package dao;

import java.util.List;

import vo.DeptVo;

public interface DeptDao {
	
	//전체조회
	List<DeptVo> selectList();
	
}
