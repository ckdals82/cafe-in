package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.SawonVo;

//해당 Dao는 auto-detact로 생성 => 생성된 객체의 id="sawon_dao"

@Repository("sawon_dao")
public class SawonDaoImpl implements SawonDao {
	
	public SawonDaoImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("-SawonDaoImpl()-");
	}
	
	@Autowired
	SqlSession sqlsession;
	
	@Override
	public List<SawonVo> selectList() {
		// TODO Auto-generated method stub
		return sqlsession.selectList("sawon.sawon_list");
	}
	
	

}
