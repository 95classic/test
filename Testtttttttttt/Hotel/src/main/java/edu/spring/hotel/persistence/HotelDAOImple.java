package edu.spring.hotel.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.hotel.domain.HotelVO;
import edu.spring.hotel.domain.MemberVO;
import edu.spring.hotel.pageutil.PageCriteria;

@Repository
public class HotelDAOImple implements HotelDAO{
	private static final Logger logger =
			LoggerFactory.getLogger(HotelDAOImple.class);
	private static final String NAMESPACE =
			"edu.spring.hotel.HotelMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public HotelVO select(int hotelId) {
		logger.info("select()ȣ�� : hotelId = " + hotelId);
		return sqlSession.selectOne(NAMESPACE + ".select_by_hotel_id", hotelId);
 	} // end select �� �˻�

	@Override
	public List<HotelVO> select() {
		logger.info("select()ȣ��");
		return sqlSession.selectList(NAMESPACE + ".select_all_default");
	} // end select_all ��ü �˻�

	@Override
	public List<HotelVO> selectAllByPriceDesc() {
		logger.info("select()ȣ��");
		return sqlSession.selectList(NAMESPACE + ".select_all_price_desc");
	} // end select_all_by_price_desc ���� �������� ��ü�˻�

	@Override
	public List<HotelVO> selectAllByPriceAsc() {
		logger.info("select()ȣ��");
		return sqlSession.selectList(NAMESPACE + ".select_all_price_asc");
	} // end select_all_by_price_desc ���� �������� ��ü�˻�

	@Override
	public List<HotelVO> selectAllByReviewDesc() {
		logger.info("selcet()ȣ��");
		return sqlSession.selectList(NAMESPACE + ".select_all_review_desc");
	} // end selectAllByReviewDesc ���� �������� ��ü�˻�

	@Override
	public List<HotelVO> select(PageCriteria criteria) {
		logger.info("select()ȣ��");
		logger.info("start = " + criteria.getStart());
		logger.info("end = " + criteria.getEnd());
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	} // select ȣ�� ����¡ ó�� 

	@Override
	public int getTotalCounts() {
		logger.info("getTotalcount()ȣ��");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	} // getTotalCounts ��ü ȣ�� �� �ҷ�����
	
	@Override
	public int updateReviewCnt(int amount, int hotelId) {
		logger.info("updateReplyCnt() ȣ��");
		logger.info("amount = " + amount);
		logger.info("hotelId = " + hotelId);
		Map<String, Integer> args = new HashMap<>();
		args.put("amount", amount);
		args.put("hotelId", hotelId);
		return sqlSession.update(NAMESPACE + ".update_review_cnt", args);
	}

} // end HotelDAOImple
