package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import vo.*;

public class BoardDao implements IBoardDao {

	// 글 목록
	@Override
	public List<Board> selectBoardListByPage(Connection conn, int rowPerPage, int beginRow) throws Exception {

		List<Board> list = null;

		String sql = "SELECT board_no boardNo, " + "board_title boardTitle," + "board_writer boardWriter, "
				+ "board_contents boardContents, " + "create_date createDate, " + "board_read boardRead, "
				+ "board_nice boardNice" + " \r\n FROM board ORDER BY board_no DESC limit ?,?";

		PreparedStatement stmt = null;
		ResultSet rs = null;
		Board board = new Board();

		try {
			list = new ArrayList<Board>();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, beginRow);
			stmt.setInt(2, rowPerPage);
			rs = stmt.executeQuery();

			System.out.println(rs + " : rs");

			while (rs.next()) {
				board = new Board();
				board.setBoardNo(rs.getInt("boardNo"));
				board.setBoardTitle(rs.getString("boardTitle"));
				board.setBoardWriter(rs.getString("boardWriter"));
				board.setBoardContents(rs.getString("boardContents"));
				board.setCreateDate(rs.getString("createDate"));
				board.setBoardRead(rs.getInt("boardRead"));
				board.setBoardNice(rs.getInt("boardNice"));

				list.add(board);

			}

			System.out.println(list + ": 목록");

		} finally {
			if (rs != null) {
				rs.close();
			}

			if (stmt != null) {
				stmt.close();
			}
		}

		return list;
	}

	//글 상세보기
	public List<Board> selectBoardOne(Connection conn, int boardNo) throws Exception {

		List<Board> list = null;

		String sql = "	 SELECT  board_title boardTitle,\r\n" + "				 board_writer boardWriter,\r\n"
				+ "				 board_contents boardContents,\r\n" + "				 create_date createDate\r\n"
				+ "				 FROM board WHERE board_no = ?";

		PreparedStatement stmt = null;
		ResultSet rs = null;
		Board board = new Board();

		try {
			list = new ArrayList<Board>();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, boardNo);
			rs = stmt.executeQuery();

			System.out.println(rs + " : rs");

			while (rs.next()) {
				board = new Board();
				board.setBoardTitle(rs.getString("boardTitle"));
				board.setBoardContents(rs.getString("boardContents"));
				board.setBoardWriter(rs.getString("boardWriter"));
				board.setCreateDate(rs.getString("createDate"));

				list.add(board);

			}
			System.out.println(list + ": 글상세보기");

		} finally {
			if (rs != null) {
				rs.close();
			}

			if (stmt != null) {
				stmt.close();
			}
		}

		return list;
	}

	// 마지막 페이지
	public int BoardlastPage(Connection conn) throws SQLException {
		int totalCount = 0;
		String sql = "SELECT COUNT(*) From board";
		PreparedStatement stmt = null;
		ResultSet rs = null;

		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();

		if (rs.next()) {
			totalCount = rs.getInt("count(*)");
		}

		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		System.out.println(totalCount + "totalCount");
		return totalCount;
	}

	
	//게시글 입력
	@Override
	public int insertBoard(Connection conn, Board board) throws Exception {

		String sql = "INSERT INTO board "
				+ "( board_title, board_contents, board_pw ,create_date) "
				+ "VALUES ( ?, ?, PASSWORD(?), NOW())";
	
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
		stmt = conn.prepareStatement(sql);
	
		
		stmt.setString(1, board.getBoardTitle()); 
		stmt.setString(2, board.getBoardContents());
		stmt.setString(3, board.getBoardPw());
		
		rs = stmt.executeQuery();
		
		} finally {

			rs.close();
			stmt.close();
			conn.close(); 
		}
		
		int row = 0;
		return row;
	}


}