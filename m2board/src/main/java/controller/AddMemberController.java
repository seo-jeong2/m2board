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

@WebServlet("/addMember")
public class AddMemberController extends HttpServlet {
	private IMemberService memberService;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/WEB-INF/view/addMember.jsp").forward(request, response);
		System.out.println("회원가입");
	
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
		
		String memberId = request.getParameter("memberId");
		String memberPass = request.getParameter("memberPass");
		String memberName = request.getParameter("memberName");
		String memberTelephone = request.getParameter("memberTelephone");
		String memberAddress = request.getParameter("memberAddress");
		
		
		System.out.println("아이디 : " + memberId);
    	System.out.println("비밀번호 : " + memberPass);
    	System.out.println("이름 : " + memberName);
    	System.out.println("전화번호 : " + memberTelephone);
    	System.out.println("주소: " + memberAddress);
    			
		
		Member paramMember = new Member();
		paramMember.setMemberId(memberId);
		paramMember.setMemberPass(memberPass);
		paramMember.setMemberName(memberName);
		paramMember.setMemberTelephone(memberTelephone);
		paramMember.setMemberAddress(memberAddress);
		
		memberService = new MemberService();
		memberService.addMember(paramMember);
		
	
		response.sendRedirect(request.getContextPath()+"/addMember");
		
		
		
	}
	

	
	
}

