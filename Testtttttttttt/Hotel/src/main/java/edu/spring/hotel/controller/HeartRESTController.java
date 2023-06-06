package edu.spring.hotel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.hotel.domain.HeartVO;
import edu.spring.hotel.service.HeartService;

@RestController
@RequestMapping(value="/main/heart")
public class HeartRESTController {
	private static final Logger logger =
			LoggerFactory.getLogger(HeartRESTController.class);
    @Autowired
    private HeartService heartService;
    

    @PostMapping
    @ResponseBody
    public ResponseEntity<Integer> heartPOST(@RequestBody HeartVO vo) {
    	logger.info("heartPOST() ȣ��: vo = " + vo.toString());
    	// ����Ʈ ������ ������ 
    	int heartNo = vo.getHeartNo();
    	int hotelId = vo.getHotelId();
    	String memberId = vo.getMemberId();
   
    	
    	// vo�� ������ �����ϰ� �鿡�� ����Ʈ�� 
    	HeartVO heart = new HeartVO();
    	heart.setHeartNo(heartNo);
    	heart.setHotelId(hotelId);
    	heart.setMemberId(memberId);
    	
    	//���ƿ� ���� Ȯ��
    	int count = heartService.read(heart);
    	logger.info("���ƿ� ���� ��������");
    	int result =0;
    	
    	if(count == 0) {
    		heartService.create(heart);
    		result =1;
    		
    	} else {
    		 heartService.delete(heart);
    		 result = 0;
    	}
    	return new ResponseEntity<Integer>(result, HttpStatus.OK);
    } // end heartPOST
}