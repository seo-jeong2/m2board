package repository;

import java.sql.*;
import java.util.*;

import vo.*;

public interface IBoardDao {
	List<Map<String, Object>> selectBoardListByPage (Connection conn, int rowPerPage, int beginRow);
	int selectBoardCnt();
	
	
	

}
