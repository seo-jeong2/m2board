package service;

import java.sql.Connection;
import java.sql.SQLException;

import repository.MemberDao;
import vo.Member;

public class MemberService implements IMemberService {

	// 로그인
	@Override
	public Member getMemberByLogin(Member paramMember) {

		Connection conn = null;
		Member member = new Member();

		try {
			conn = new DBUtil().getConnection();
			conn.setAutoCommit(false);
			// executeUpdate() 실행 시 자동 커밋방지

			MemberDao memberDao = new MemberDao();
			member = memberDao.selectMemberByLogin(conn, paramMember);

			conn.commit();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return member;
	}

	//회원가입
	@Override
	public boolean addMember(Member paramMember) {

		Connection conn = null;

		try {
			conn = new DBUtil().getConnection();
			conn.setAutoCommit(false);// 자동 커밋 방지

			MemberDao memberDao = new MemberDao();
			memberDao.insertMember(conn, paramMember);

			conn.commit();

		} catch (Exception e) {
			e.printStackTrace(); // console에 예외메세지 출력
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

}