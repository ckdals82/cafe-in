package service;

import java.util.List;

import dao.BoardDao;

public class BoardServiceImpl implements BoardService {
	
	//interface(명세서: 설명서)
	BoardDao dao;
	
	public BoardServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	//spring으로부터 BoardDao를 injection받는다.
	public BoardServiceImpl(BoardDao dao) {
		super();
		this.dao = dao;
	}



	@Override
	public List selectList() {
		// TODO Auto-generated method stub
		return dao.selectList();
	}

}
