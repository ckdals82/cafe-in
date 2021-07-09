package dao;

import java.util.List;

import vo.SawonVo;

public interface SawonDao {
	
	//전체조회
	List<SawonVo> selectList();
}
