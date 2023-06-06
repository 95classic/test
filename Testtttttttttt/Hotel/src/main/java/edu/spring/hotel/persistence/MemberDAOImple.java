package edu.spring.hotel.persistence;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.hotel.domain.MemberVO;

@Repository
public class MemberDAOImple implements MemberDAO{
	private static final Logger logger =
			LoggerFactory.getLogger(MemberDAOImple.class);
	private static final String NAMESPACE =
			"edu.spring.hotel.MemberMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(MemberVO vo) {
		logger.info("insert() ȣ�� : vo = " + vo.toString());
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	} // end insert ���

	@Override
	public MemberVO select(String memberId) {
		logger.info("select()ȣ�� : memberId = " + memberId);
		return sqlSession.selectOne(NAMESPACE + ".select_by_member_id", memberId);
	} // end select �󼼰˻�

	@Override
	public int update(MemberVO vo) {
		logger.info("update() ȣ�� : vo = " + vo.toString());
		return sqlSession.update(NAMESPACE + ".update", vo);
	} // end update ����

	@Override
	public int delete(MemberVO memberId) {
		logger.info("delete() ȣ�� : memberId = " + memberId);
		return sqlSession.delete(NAMESPACE + ".delete", memberId);
	} // end delete ����

	@Override
	public int idcheck(MemberVO vo) {
		logger.info("idcheck()ȣ�� : vo = " + vo.toString());
		return sqlSession.selectOne(NAMESPACE + ".idcheck", vo);
	} // end idcheck ���̵� �ߺ�üũ

	@Override
	public MemberVO login(MemberVO vo) {
		logger.info("login() ȣ��");
		logger.info("vo = " + vo.toString());
		return sqlSession.selectOne(NAMESPACE + ".login", vo);
	} // end login �α���
	
} // end MemberDAOImple
