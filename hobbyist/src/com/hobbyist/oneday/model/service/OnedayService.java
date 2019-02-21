package com.hobbyist.oneday.model.service;

import static common.JdbcTemplate.close;
import static common.JdbcTemplate.commit;
import static common.JdbcTemplate.getConnection;
import static common.JdbcTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.hobbyist.oneday.model.vo.Oneday;
import com.hobbyist.member.model.vo.Member;
import com.hobbyist.oneday.model.dao.OnedayDao;
import com.hobbyist.oneday.model.vo.Cate;
import com.hobbyist.oneday.model.vo.Review;

public class OnedayService {
	
	static OnedayDao dao = new OnedayDao();
	
	// 기본 원데이클래스 목록리스트 가져오기
	public List<Oneday> onedayBasicList() {
		Connection conn = getConnection();
		List<Oneday> list = dao.onedayBasicList(conn);
		close(conn);
		return list;
	}

	// 원데이클래스 등록하기
	public int onedayInsert(Oneday Oneday) {
		Connection conn = getConnection();
		int result = dao.onedayInsert(conn, Oneday);
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	// 검색결과에 따른 갯수 가져오기
	public int searchCount(String keyword) {
		Connection conn = getConnection();
		int result = dao.searchCount(conn, keyword);
		close(conn);
		return result;
	}
	
	// 등록순 정렬
	public List<Oneday> descEnroll(String keyword, int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Oneday> list = dao.descEnroll(conn, keyword, cPage, numPerPage);
		close(conn);
		return list;
	}
	
	// 높은가격순
	public List<Oneday> descPrice(String keyword, int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Oneday> list = dao.descPrice(conn, keyword, cPage, numPerPage);
		close(conn);
		return list;
	}


	// 낮은가격순
	public List<Oneday> ascPrice(String keyword, int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Oneday> list = dao.ascPrice(conn, keyword, cPage, numPerPage);
		close(conn);
		return list;
	}
	
	// 반응형 ajax 검색결과
	public List<Oneday> ajaxSearch(String keyword) {
		Connection conn = getConnection();
		List<Oneday> list = dao.ajaxSearch(conn, keyword);
		close(conn);
		return list;
	}

	
	// 리뷰모두가져오기
		public List<Review> reviewListAll() {
			Connection conn = getConnection();
			List<Review> list = dao.reviewListAll(conn);
			close(conn);
			return list;
		}
	
	// 리뷰가져오기
	public List<Review> reviewList(int no,  int rPage, int rPerPage) {
		Connection conn = getConnection();
		List<Review> list = dao.reviewList(conn, no, rPage, rPerPage);
		close(conn);
		return list;
	}
	
	// 카테고리 조회
	public List<Cate> CateList() {
		Connection conn = getConnection();
		List<Cate> list = dao.CateList(conn);
		close(conn);
		return list;
	}
	
	// 카테고리 생성
	public int insertCate(String newCate) {
		Connection conn = getConnection();
		int result = dao.insertCate(conn, newCate);
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public List<Oneday> selectAll() {
		Connection conn = getConnection();
		List<Oneday> list = dao.selectAll(conn);
		close(conn);
		return list;
	}

	public Oneday selectOne(int no) {
		Connection conn = getConnection();
		Oneday result = dao.selectOne(conn, no);
		close(conn);
		return result;
	}
	
	// 리뷰 작성 (Ajax)
	public List<Review> reviewInsert(Review rv, int rPage, int rPerPage) {
		Connection conn = getConnection();
		List<Review> list = null;
		int result = dao.reviewInsert(conn, rv);
		
		if(result>0) {
			System.out.println("리뷰작성 완료");
			commit(conn);
			list = dao.reviewList(conn, rv.getReviewClass(), rPage, rPerPage);
		} else {
			rollback(conn);
		}
		close(conn);
		return list;
	}

	// 리뷰개수 가져오기
	public int reviewCount(int review_class) {
		Connection conn = getConnection();
		int count = dao.reviewCount(conn, review_class);
		close(conn);
		return count;
	}

	// 클래스 등록 -> 작가 찾기
	public List<Member> writerSearch(String classWriter) {
		Connection conn = getConnection();
		List<Member> list = dao.writerSearch(conn, classWriter);
		close(conn);
		return list;
	}

	public int updateOneday(Oneday oneday) {
		Connection conn = getConnection();
		int result = dao.updateOneday(conn, oneday);
		close(conn);
		return result;
	}

	public int searchCateCount(String cate, String keyword) {
		Connection conn = getConnection();
		int result = dao.searchCateCount(conn, cate, keyword);
		close(conn);
		return result;
	}

	public List<Oneday> descEnrollCate(String cate, String keyword, int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Oneday> list = dao.descEnrollCate(conn, cate, keyword, cPage, numPerPage);
		close(conn);
		return list;
	}

	public List<Oneday> descPriceCate(String cate, String keyword, int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Oneday> list = dao.descPriceCate(conn, cate, keyword, cPage, numPerPage);
		close(conn);
		return list;
	}

	public List<Oneday> ascPriceCate(String cate, String keyword, int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Oneday> list = dao.ascPriceCate(conn, cate, keyword, cPage, numPerPage);
		close(conn);
		return list;
	}

}