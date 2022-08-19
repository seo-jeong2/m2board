package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.IMemberService;
import service.MemberService;
import vo.Member;


@WebServlet("/index")
public class IndexController extends HttpServlet {
	private IMemberService memberService;
	//form
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
		
		System.out.println("목록보기");
	}


	//action
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String id = request.getParameter("memberId");
		String name = request.getParameter("memberName");
		String pw = request.getParameter("memberPass");
		
		Member paramMember = new Member();
		paramMember.setMemberId(id);
		paramMember.setMemberName(name);
		paramMember.setMemberPass(pw);
		
		memberService = new MemberService();
		Member member = memberService.getMemberByLogin(paramMember);		
		session.setAttribute("user", "Member"); 
		session.setAttribute("id", member.getMemberId());
		session.setAttribute("name", member.getMemberName());
		
		
		response.sendRedirect(request.getContextPath()+"/index");
}

}