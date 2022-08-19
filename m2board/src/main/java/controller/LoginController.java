package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.IMemberService;
import service.MemberService;
import vo.Member;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private IMemberService memberService;
	
	//login form
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginMember") != null) { //로그인 되어 있는 상태이면
			response.sendRedirect(request.getContextPath() + "/index");
			return;
		}
		
		//뷰 포워딩
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}

	//login action
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginMember")!= null) { //로그인 되어 있는 상태이면
			response.sendRedirect(request.getContextPath() + "/index");
			return;
		}

		request.setCharacterEncoding("utf-8");
		
		
		String id = request.getParameter("memberId");
		String pw = request.getParameter("memberPass");
		
		System.out.println("회원아이디 : " + id);
    	System.out.println("비밀번호 : " + pw);
		
		Member paramMember = new Member();
		paramMember.setMemberId(id);
		paramMember.setMemberPass(pw);
		
	
	//new
		memberService = new MemberService();
		Member member = memberService.getMemberByLogin(paramMember);		
		
		 if(member == null) { // 로그인 실패
	     response.sendRedirect(request.getContextPath()+"/loginController");
	     System.out.println("회원 로그인 실패");		
	     return;
	     }
		
		System.out.println("회원 로그인 성공");
		session.setAttribute("user", "Member");  
		session.setAttribute("id", member.getMemberId());
		session.setAttribute("name", member.getMemberName());
		session.setAttribute("pass", member.getMemberPass());
		 
	
		//매개변수로 세션받아야함 
		//request안에 session참조할 메서드있음
		session.setAttribute("loginMember", paramMember);
		
		response.sendRedirect(request.getContextPath()+"/index");
		

	}	

}
