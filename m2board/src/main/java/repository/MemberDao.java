package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.Member;

public class MemberDao implements IMemberDao {

	// 로그인
	@Override
	public Member selectMemberByLogin(Connection conn, Member paramMember) throws Exception {
		Member member = null;

		String sql = "SELECT member_id memberId, \r\n" + "member_pass memberPass,\r\n" + "member_name memberName \r\n"
				+ "FROM member WHERE member_id=? AND member_pass=PASSWORD(?)";

		PreparedStatement stmt = null;
		ResultSet rset = null;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, paramMember.getMemberId());
			stmt.setString(2, paramMember.getMemberPass());
			rset = stmt.executeQuery();

			if (rset.next()) {
				member = new Member();
				member.setMemberId(rset.getString("memberId"));
				member.setMemberPass(rset.getString("memberPass"));

			}

		} finally {
			stmt.close();
			rset.close();

		}

		return member;

	}

	// 회원가입
	@Override
	public int insertMember(Connection conn, Member member) throws Exception {
		int row = 0;
		String sql = "Insert into member (member_id , member_pass, member_name, member_address, member_telephone, create_date, update_date) values (?,password(?),?,?,?,now(),now())";

		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPass());
			stmt.setString(3, member.getMemberName());
			stmt.setString(4, member.getMemberAddress());
			stmt.setString(5, member.getMemberTelephone());

			row = stmt.executeUpdate();

		} finally {

			if (stmt != null) {
				stmt.close();
			}
		}
		return row;
	}
}
