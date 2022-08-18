package service;

import java.util.List;
import java.util.Map;

public interface IBoardService {
	//List<Board>, int lastPage
	List<Map<String,Object>> getBoardList(int rowPerPage, int currentPage);
	
	
	
	
	
	
	

}
