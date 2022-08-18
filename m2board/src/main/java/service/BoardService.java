package service;

import java.util.*;
import repository.*;
import vo.*;

import java.sql.*;


public class BoardService implements IBoardService {
	private IBoardDao dao;
	
	
	public List<Map<String, Object>> getBoardList(int rowPerPage, int currentPage) {
		
		List<Map<String, Object>> m = new ArrayList<>();

		Connection conn = null;
		int beginRow = 0;	
		beginRow = (currentPage -1 ) * rowPerPage;
		
		try {
			conn = new DBUtil().getConnection();
			BoardDao boardDao = new BoardDao();
			
			m = boardDao.selectBoardListByPage(conn, rowPerPage, beginRow);
			System.out.println(m +": 글목록");
			
			if(m ==null ) {
				throw new Exception();
			}
			
			conn.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return m;
		
	}
	
		
		
		
		
	

}
	

	
	
