package repository;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import vo.*;

public class BoardDao implements IBoardDao{

	@Override
	public List<Map<String, Object>> selectBoardListByPage(Connection conn, int rowPerPage, int beginRow) {
		List<Map<String, Object>> list = new ArrayList<>();
		
		
		
		
		
		
		
		
		return list;
	}

	@Override
	public int selectBoardCnt() {
		// TODO Auto-generated method stub
		return 1;
	}

}
