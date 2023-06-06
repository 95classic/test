package edu.spring.hotel.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.hotel.domain.BoardVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.pageutil.PageMaker;
import edu.spring.hotel.service.BoardService;

@Controller
@RequestMapping(value="/main/board") // /hotel/board
public class BoardController {
	private static final Logger logger = 
			LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list") // board ������ list.jsp
	public void list(Model model, Integer page, Integer numsPerPage) {
		logger.info("list() ȣ��");
		logger.info("page = " + page + ", numsPerPage = " + numsPerPage);
		
		// ����¡ ó��
		PageCriteria criteria = new PageCriteria();
		if (page != null) {
			criteria.setPage(page);
		}
		
		if (numsPerPage != null) {
			criteria.setNumsPerPage(numsPerPage);
		}
		
		List<BoardVO> list = boardService.read(criteria);
		model.addAttribute("list", list);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(boardService.getTotalCounts());
		pageMaker.setPageData();
		model.addAttribute("pageMaker", pageMaker);
		
	} // end list()
	
	@GetMapping("/register") // board ������ register.jsp
	public void registerGET() {
		logger.info("registerGET() ȣ��");
	} // end registerGET()
	
	@PostMapping("/register")
	public String registerPOST(BoardVO vo, RedirectAttributes reAttr) {
		logger.info("registerPOST() ȣ��");
		logger.info(vo.toString());
		int result = boardService.create(vo);
		logger.info(result + "�� ����");
		
		if (result == 1) {
			reAttr.addFlashAttribute("result", "registerSuccess");
			return "redirect:/main/board/list";
		} else {
			return "redirect:/main/board/register";
		}
	} // end registerPOST()
	
	@GetMapping("/detail") // board ������ detail.jsp
	public void detailGET(Model model, Integer boardId, Integer page) {
		logger.info("detailGET() ȣ�� : boardId = " + boardId);
		BoardVO vo = boardService.read(boardId);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
	} // end detailGET()
	
	@GetMapping("/update") // board ������ update.jsp
	public void updateGET(Model model, Integer boardId, Integer page) {
		logger.info("updateGET() ȣ�� : boardId = " + boardId);
		BoardVO vo = boardService.read(boardId);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
	} // end updateGET()
	
	@PostMapping("/update") // board ������ update.jsp
	public String updatePOST(BoardVO vo, Integer page, RedirectAttributes reAttr) {
		logger.info("updatePOST() ȣ�� : vo = " + vo.toString());
		int result = boardService.update(vo);
		if (result == 1) {
			reAttr.addFlashAttribute("result", "updateSuccess");
			return "redirect:/main/board/list?page=" + page;
		} else {
			return "redirect:/main/board/update?boardId=" + vo.getBoardId();
		}
	} // end updatePOST()
	
	@PostMapping("/delete") // board ������ delete.jsp
	public String deletePOST(Integer boardId, RedirectAttributes reAttr) {
		logger.info("delete() ȣ�� : boardId = " + boardId);
		int result = boardService.delete(boardId);
		if (result == 1) {
			// Ű-�� ����
			reAttr.addFlashAttribute("result", "deleteSuccess");
			return "redirect:/main/board/list";
		} else {
			return "redirect:/main/board/list";
		}
	} // end deletePOST()
	
} // end BoardController
