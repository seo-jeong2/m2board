package service;

import java.util.*;
import repository.*;
import vo.*;

import java.sql.*;

public class BoardService implements IBoardService {
	private IBoardDao dao;

	// 글 목록
	public Map<String, Object> getBoardList(int rowPerPage, int currentPage) {

		Map<String, Object> map = null;
//		List<Board> list  = new ArrayList<>();

		Connection conn = null;
		BoardDao boardDao = new BoardDao();

		int beginRow = (currentPage - 1) * rowPerPage;

		try {

			conn = new DBUtil().getConnection();
			map = new HashMap<>();

			map.put("lastPage", boardDao.BoardlastPage(conn));
			map.put("list", boardDao.selectBoardListByPage(conn, rowPerPage, beginRow));
//			list = boardDao.selectBoardListByPage(conn, currentPage, rowPerPage);
			System.out.println(map);

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
		return map;

	}

	// 글 상세보기
	public Map<String, Object> getBoardOne(int boardNo) {

		Map<String, Object> map = null;
		Connection conn = null;

		try {

			conn = new DBUtil().getConnection();
			map = new HashMap<>();
			BoardDao boardDao = new BoardDao();
			map.put("list", boardDao.selectBoardOne(conn, boardNo));

			System.out.println(map + "상세보기");
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
		return map;

	}

	// 마지막 페이지
	public int getLastPage(int rowPerPage) {

		Connection conn = null;

		try {
			conn = new DBUtil().getConnection();
			conn.setAutoCommit(false);

			BoardDao boardDao = new BoardDao();
			rowPerPage = boardDao.BoardlastPage(conn);

			conn.commit();
		}

		catch (Exception e) {
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

		return rowPerPage;

	}

	// 글쓰기
	@Override
	public boolean addBoard(Board paramBoard) {

		Connection conn = null;

		try {

			conn = new DBUtil().getConnection();
			conn.setAutoCommit(false);
			BoardDao boardDao = new BoardDao();
			boardDao.insertBoard(conn, paramBoard);

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

		return true;

	}

}
