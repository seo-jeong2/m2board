package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.IBoardService;



@WebServlet("/BoardList")
public class BoardListController extends HttpServlet {
	
	private IBoardService boardService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//컨트롤러
		//1)요청받아서 분석
		final int rowPerPage = 10;
		
		int currentPage = 1;
		if(request.getParameter("currentPage") !=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		//2)서비스 레이어를 요청 (메서드 호출) -> 모델값(자료구조) 구하기 위함
		//new
		Map<String,Object > map  = boardService.getBoardList(rowPerPage, currentPage);
		request.setAttribute("lastPage", map.get("lastPage"));
		request.setAttribute("list", map.get("list"));
		
		//3) view 포워딩
		request.getRequestDispatcher("/WEB-INF/view/boardList.jsp");
	}

	
}
