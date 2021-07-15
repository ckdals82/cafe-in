package service;

import java.util.Map;

import vo.ProductVo;

public interface ProductService {
	
	//입고/출고/재고 목록 가져오기
	Map selectList();
	
	//입고
	int insert_in(ProductVo vo) throws Exception;
	
	//출고
	int insert_out(ProductVo vo) throws Exception;
	
	
}
