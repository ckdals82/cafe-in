package dao;

import java.util.List;

import vo.CafeSearchVo;

public interface FilterDao {

	List<CafeSearchVo> selecList(CafeSearchVo vo);


}
