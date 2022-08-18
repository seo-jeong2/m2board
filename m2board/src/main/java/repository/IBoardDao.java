package repository;

import java.sql.*;

import java.util.*;

import vo.*;

public interface IBoardDao {
	List<Board> selectBoardListByPage (Connection conn, int rowPerPage, int beginRow) throws Exception ;

	int BoardlastPage(Connection conn) throws SQLException;
	
	List<Board> selectBoardOne(Connection conn, int boardNo) throws Exception;
	
	int insertBoard(Connection conn, Board board) throws Exception;

}
