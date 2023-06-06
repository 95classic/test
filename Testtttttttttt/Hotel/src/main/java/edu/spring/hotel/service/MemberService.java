package edu.spring.hotel.service;

import edu.spring.hotel.domain.MemberVO;
import edu.spring.hotel.pageutil.PageCriteria;

// CRUD(create, Read, Update, Delete)
public interface MemberService {
	int create(MemberVO vo);
	MemberVO read(String memberId);
	int update(MemberVO vo);
	int delete(MemberVO  memberId);
	
	MemberVO login(MemberVO vo) throws Exception; //�α���
	
	int idcheck(MemberVO vo); // ���̵� �ߺ�üũ
} // end MemberService 
