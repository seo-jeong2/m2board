package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import service.IBoardService;

@WebServlet("/boardOne")
public class BoardOneController extends HttpServlet {
	private IBoardService boardService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));  
		
		boardService = new BoardService();
		Map<String, Object> map = boardService.getBoardOne(boardNo);
		request.setAttribute("list", map.get("list"));
		
		//뷰 포워딩
		request.getRequestDispatcher("/WEB-INF/view/boardOne.jsp").forward(request, response);

	}

	
}
