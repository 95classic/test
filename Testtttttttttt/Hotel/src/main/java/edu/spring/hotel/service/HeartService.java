package edu.spring.hotel.service;

import edu.spring.hotel.domain.HeartVO;

public interface HeartService {

	// ���ƿ� ���
	int create(HeartVO vo) ;
	
	// ���ƿ� �������� 
	int read(HeartVO vo);
	
	// ���ƿ� ���
	int delete(HeartVO vo);
	
	// ��ü ���ƿ� �� �޾ƿ���
//	int getHeartTotalCounts();


}
