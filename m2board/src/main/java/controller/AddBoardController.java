package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import service.IBoardService;


@WebServlet("/addBoard")
public class AddBoardController extends HttpServlet {
	private IBoardService boardService;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String boardTitle = request.getParameter("boardTitle"); 
		String content = request.getParameter("boardContents");
		String pw = request.getParameter("boardPw"); 
		
		boardService = new BoardService();
		request.setAttribute(pw, content);
		
		
		
		
		
		
		
	}

	
	

}
