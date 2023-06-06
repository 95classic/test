package edu.spring.hotel.persistence;

import edu.spring.hotel.domain.HeartVO;

public interface HeartDAO {
	// ���ƿ� �߰�
	int insert(HeartVO vo);
	
	// ���ƿ� ��� 
	int delete(HeartVO vo);
	
	// ���ƿ� �����ֱ� 
	int select(HeartVO vo);
	
	// ���ƿ� �� ���� ��������
	int getHeartTotalCounts();
	// ��Ʈ ��ȣ ��ȸ (hotelId�� memberId)��
//	int getHeartNOByHotelIdAndMemberId(int hotelId, String memberId);
	

} // end HeartDAO
