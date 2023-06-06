package edu.spring.hotel.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.hotel.domain.HotelVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.persistence.HotelDAO;

@Service 
public class HotelServiceImple implements HotelService {
	private static final Logger logger =
			LoggerFactory.getLogger(HotelServiceImple.class);
	
	@Autowired
	private HotelDAO dao;

	@Override
	public HotelVO read(int hotelId) {
		logger.info("read()ȣ�� : hotelId = " + hotelId);
		return dao.select(hotelId);
	} // end read �󼼰˻�

	@Override
	public List<HotelVO> read(PageCriteria criteria) {
		logger.info("read()ȣ��");
		return dao.select(criteria);
	} // end readAll ��ü �˻�(����¡ ó��)

	@Override
	public List<HotelVO> readOrderByPriceDesc() {
		logger.info("read()ȣ��");
		return dao.selectAllByPriceDesc();
	} // end readOrderByPriceDesc ���� �������� ��ü �˻�

	@Override
	public List<HotelVO> readOrderByPriceAsc() {
		logger.info("read()ȣ��");
		return dao.selectAllByPriceAsc();
	} // end readOrderByPriceAsc ���� �ø����� ��ü �˻�

	@Override
	public List<HotelVO> readOrderByReviewDesc() {
		logger.info("read()ȣ��");
		return dao.selectAllByReviewDesc();
	} // end readOrderByReviewDesc ���� �������� ��ü �˻�

	

	@Override
	public int getTotalCounts() {
		logger.info("getTotalCounts()ȣ��");
		return dao.getTotalCounts();
	} // end getTotalCounts ��ü ȣ�� �� �ҷ����� 



}
