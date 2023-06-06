package edu.spring.hotel.persistence;

import edu.spring.hotel.domain.MemberVO;

public interface MemberDAO {
	
	int insert(MemberVO vo); // ȸ�� ���
	
	MemberVO select(String memberId); // ȸ�� �󼼰˻�
	
	int update(MemberVO vo); // ȸ�� ����
	
	int delete(MemberVO memberId); // ȸ�� ����
	
	int idcheck(MemberVO vo); // ���̵� �ߺ�üũ
	
	MemberVO login(MemberVO vo) throws Exception; // �α���
}
