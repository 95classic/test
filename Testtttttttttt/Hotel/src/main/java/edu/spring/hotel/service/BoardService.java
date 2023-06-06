package edu.spring.hotel.service;

import java.util.List;

import edu.spring.hotel.domain.BoardVO;
import edu.spring.hotel.pageutil.PageCriteria;

//CRUD(Create, Read, Update, Delete)

public interface BoardService {
	// �Խñ� �ۼ�
	int create(BoardVO vo);
	// �Խñ� ��ü �б�
	List<BoardVO> read(PageCriteria criteria);
	// �Խñ� �ϳ� �б�
	BoardVO read(int boardId);
	// �Խñ� ����
	int update(BoardVO vo);
	// �Խñ� ����
	int delete(int boardId);
	// ��ü �Խñ� �� �޾ƿ���
	int getTotalCounts();
} // end BoardService
