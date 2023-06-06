package edu.spring.hotel.service;

import java.util.List;


import edu.spring.hotel.domain.HotelVO;
import edu.spring.hotel.pageutil.PageCriteria;

// CRUD(Create, Read, Update, Delete)
public interface HotelService {
	HotelVO read(int hotelId); // �� �˻�
	
	List<HotelVO> read(PageCriteria criteria); // ��ü �˻� (����¡ ó��)
 	
	List<HotelVO> readOrderByPriceDesc(); // ���ݺ� �������� ��ü �˻�
	
	List<HotelVO> readOrderByPriceAsc(); // ���ݺ� �ø����� ��ü �˻�
	
	List<HotelVO> readOrderByReviewDesc(); // ����� �������� ��ü �˻�
	
	int getTotalCounts(); //  ��ü ȣ�� �� �޾ƿ��� 
} // end HotelService
