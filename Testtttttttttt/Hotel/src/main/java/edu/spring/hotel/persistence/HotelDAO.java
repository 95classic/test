package edu.spring.hotel.persistence;

import java.util.List;

import edu.spring.hotel.domain.HotelVO;
import edu.spring.hotel.pageutil.PageCriteria;


public interface HotelDAO {
	
	
	HotelVO select(int hotelId); // ȣ�� �� �˻�
	
	List<HotelVO> select(); // ȣ�� ���� �˻�
	
	List<HotelVO> selectAllByPriceDesc(); // ȣ�� ���� �������� ���� ��ü�˻�
	
	List<HotelVO> selectAllByPriceAsc(); // ȣ�� ���� �������� ���� ��ü�˻�
	
	List<HotelVO> selectAllByReviewDesc(); // ȣ�� ���� ���� �� �˻�
	
	List<HotelVO> select(PageCriteria criteria); // ȣ�� ����¡ ó���� ���� ��ü �˻�

	int getTotalCounts(); // ��ü ȣ�� �� �ҷ�����
	
	int updateReviewCnt(int amount, int hotelId); // ���� ����, ���� �� ���� ���� ����
	
}
