package dao;

import java.util.List;

import vo.ProductVo;

public interface ProductDao {
	
	List<ProductVo> list();
	
	int insert(ProductVo vo);
	int delete(int idx);
	int update(ProductVo vo);
	
	//선택적 재정의(JDK 1.8 later)
	default ProductVo selectOne(String name) { return null;}
	
}
