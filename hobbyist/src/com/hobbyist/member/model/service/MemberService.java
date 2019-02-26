package com.hobbyist.member.model.service;

import static common.JdbcTemplate.close;
import static common.JdbcTemplate.getConnection;
import static common.JdbcTemplate.commit;
import static common.JdbcTemplate.rollback;

import java.sql.Connection;

import com.hobbyist.member.model.dao.MemberDao;
import com.hobbyist.member.model.vo.Member;

public class MemberService {

	private MemberDao dao = new MemberDao();
	
	public Member selectOne(Member m) {
		Connection conn = getConnection();
		Member result = dao.selectOne(conn,m);
		close(conn);
		return result;
	}
	
	public int enrollMember(Member m) {
		Connection conn = getConnection();
		int result = dao.enrollMember(conn,m);
		if(result>0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int emailCheck(String finalEmail) {
		Connection conn = getConnection();
		int result = dao.emailCheck(conn, finalEmail);
		close(conn);
		return result;
	}

	public int nicknameCheck(String memberNickname) {
		Connection conn = getConnection();
		int result = dao.nicknameCheck(conn, memberNickname);
		close(conn);
		return result;
	}

	public Member selectMemberName(Member m) {
		Connection conn = getConnection();
		Member result = dao.selectMemberName(conn,m);
		close(conn);
		return result;
		
	}

	public Member searchMemberPwd(Member m) {
		Connection conn = getConnection();
		Member result = dao.searchMemberPwd(conn, m);
		close(conn);
		return result;
	}

	public int updateTempPwd(Member m) {
		Connection conn = getConnection();
		int resultPwd = dao.updateTempPwd(conn, m);
		close(conn);
		return resultPwd;
	}
	
	//작가신청 합격으로 인한 맴버 데이터 수정
	public int writerPassUpdate(String memberEmail) {
		Connection conn = getConnection();
		int result = dao.writerPassUpdate(conn,memberEmail);
		if(result>0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	

	//작가신청 불합격으로 인한 맴버 데이터 수정
	public int writerFailUpdate(String memberEmail) {
		Connection conn = getConnection();
		int result = dao.writerFailUpdate(conn,memberEmail);
		if(result>0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

}
