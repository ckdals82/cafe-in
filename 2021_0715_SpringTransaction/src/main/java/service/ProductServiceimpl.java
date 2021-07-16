package service;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import dao.ProductDao;
import vo.ProductVo;

public class ProductServiceimpl implements ProductService {
	
	ProductDao product_in_dao; //입고 Dao
	
	ProductDao product_out_dao; //출고 Dao
	
	ProductDao product_remain_dao; //재고 Dao
	
	
	
	public void setProduct_in_dao(ProductDao product_in_dao) {
		this.product_in_dao = product_in_dao;
	}

	public void setProduct_out_dao(ProductDao product_out_dao) {
		this.product_out_dao = product_out_dao;
	}

	public void setProduct_remain_dao(ProductDao product_remain_dao) {
		this.product_remain_dao = product_remain_dao;
	}

	@Override
	public Map selectList() {
		// TODO Auto-generated method stub
		List<ProductVo> in_list 	= product_in_dao.list(); 	//입고목록 가져오기
		List<ProductVo> out_list 	= product_out_dao.list();	//출고목록 가져오기
		List<ProductVo> remain_list = product_remain_dao.list();//재고목록 가져오기
		
		//Map으로 포장
		Map map = new HashedMap();
		map.put("in_list", in_list);
		map.put("out_list", out_list);
		map.put("remain_list", remain_list);
		
		return map;
	}

	@Override
	public int insert_in(ProductVo vo) throws Exception {
		// TODO Auto-generated method stub
		
		//1.입고테이블 등록
		int res = product_in_dao.insert(vo);
		
		//2.재고테이블처리
		//2-1.입고상품이 재고테이블에 있는지 여부
		ProductVo remainVo = product_remain_dao.selectOne(vo.getName());
		
		if(remainVo==null) {//재고목록에 없기 때문에 등록을 해야하는 상황
			
			res = product_remain_dao.insert(vo);
			
		}else {//재고목록에 있기 때문에 수정을 해야하는 상황
			//재고수량 = 원래 재고수량 + 입고수량
			int cnt = remainVo.getCnt() + vo.getCnt();
			remainVo.setCnt(cnt);
			
			res = res * product_remain_dao.update(remainVo);
			
		}
		
		return res;
	}

	@Override
	   public int insert_out(ProductVo vo) throws Exception {
	      // TODO Auto-generated method stub

	      // 1.출고등록
	      int res = product_out_dao.insert(vo);
	      
	      // 2.재고수량 조정
	      // 해당 상품명에 해당되는 재고정보 1건
	      ProductVo remainVo = product_remain_dao.selectOne(vo.getName());
	      
	      if(remainVo==null) {   // 출고된 상품이 재고목록에 없는경우
	    	  
	    	  //강제로 예외가 던져지면=> txAdvice->rollback시킨다
	    	  throw new Exception("remain_not");
	    	  
	      }
	      
	      //출고수량이 > 재고수량보다 많은경우
	      if(vo.getCnt()> remainVo.getCnt()) {
	    	  throw new Exception("remain_lack");
	      }
	      //재고목록 수정
	      
	      //재고수량 = 원래재고수량 - 출고수량
	      int cnt = remainVo.getCnt() - vo.getCnt();
	      remainVo.setCnt(cnt);
	      
	      res = product_remain_dao.update(remainVo);
	      
	      return 0;
	   }

	  @Override
	   public int delete_in(int[] idx_array) throws Exception {
	      // TODO Auto-generated method stub
	      
	      int res = 0;
	      for(int idx : idx_array) {
	         
	         //1.입고취소된 상품명 얻어오기
	         ProductVo vo = product_in_dao.selectOne(idx);
	         
	         //2.입고목록 삭제
	         product_in_dao.delete(idx);
	         
	         //3.재고상품정보 얻어오기(입고취소한 상품명을 이용해서)
	         ProductVo remainVo = product_remain_dao.selectOne(vo.getName());
	         
	         //4.재고 수량 수정
	         int cnt = remainVo.getCnt() - vo.getCnt();
	         remainVo.setCnt(cnt);
	         
	         res = product_remain_dao.update(remainVo);
	         
	         
	      }
	      
	      
	      return res;
	   }

	   @Override
	   public int delete_out(int[] idx) throws Exception {
	      // TODO Auto-generated method stub
	      return 0;
	   }

	}






