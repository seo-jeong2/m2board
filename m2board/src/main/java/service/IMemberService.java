package service;

import vo.Member;

public interface IMemberService {
	Member getMemberByLogin(Member paramMember);
	
	boolean addMember (Member paramMember);
}
