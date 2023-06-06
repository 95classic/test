package edu.spring.hotel.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.hotel.domain.MemberVO;
import edu.spring.hotel.service.MemberService;

@Controller
@RequestMapping(value = "/main/member") // url : /hotel/member���� �س����� ���� member ������ �������
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;

	@GetMapping("/register")
	public void registerGET() {
		logger.info("registerGET()");
	} // end registerGET()
	
	@PostMapping("/register")
	public String registerPOST(MemberVO vo, RedirectAttributes reAttr) {
		logger.info("registerPOST() ȣ��");
		logger.info(vo.toString());
		int result = memberService.create(vo);
		logger.info(result + "�� ����");
		if (result == 1) {
			reAttr.addFlashAttribute("result", "registerSuccess");
			return "redirect:/main/main";
		} else {
			return "redirect:/main/member/register";
		}
	} // end registerPOST() 
	
	@GetMapping("/idCheck")
	public void idCheckGET() {
	
	}// end idcheckGET()
	
	@ResponseBody
	@PostMapping("/idCheck")
	public int idcheckPOST(MemberVO vo) {
	    logger.info("idcheckPOST() ȣ��");
	    logger.info(vo.toString());
	   
	    int result = memberService.idcheck(vo);
	    logger.info("��������� ����");
	    return result;

	} // end idcheckPOST() ���̵� �ߺ�Ȯ��
	
	// �α��� �޼ҵ�
	@GetMapping("/login")
	public void loginGET() {
		logger.info("loginGET() ȣ��");	
	} // end loginGET()

	// �α��� �޼ҵ�
	@PostMapping("/login")
	public String loginPOST(MemberVO vo, RedirectAttributes reAttr, HttpSession session, HttpServletRequest request) throws Exception {
		logger.info("loginPOST() ȣ��");

		vo = memberService.login(vo);
		
		// targetURI ��������
        String targetURI = (String)session.getAttribute("targetURI");
        System.out.println(targetURI);
        if(targetURI != null && !targetURI.equals("")) {
            session.removeAttribute("targetURI"); // targetURI�� �� �� ����ϸ� �����ش�
            return "redirect:" + targetURI;
        }

		if (vo != null) {
			session.setAttribute("memberId", vo.getMemberId());
			reAttr.addFlashAttribute("result", "loginSuccess");
			return "redirect:/main/main";
		} else {
			return "redirect:/main/member/login";
		}
	} // end loginPOST()
	
	// �α׾ƿ� �޼ҵ�
	@GetMapping("/logout")
	public String logoutGET(HttpSession session, RedirectAttributes reAttr) {
		logger.info("logoutGET() ȣ��");
		session.removeAttribute("memberId");
		reAttr.addFlashAttribute("result", "logoutSuccess");
		return "redirect:/main/main";
	} // end logoutGET()
	
	// ���������� �޼ҵ�
	@GetMapping("/mypage")
	public void myPage() {
		logger.info("mypPage() ȣ��");
	} // end myPage()
	
	@GetMapping("/update")
	public void updateGET() {
		logger.info("updateGET() ȣ��");
		
	} // end updateGET()
	
	@PostMapping("/update")
	public String updatePOST(MemberVO vo, RedirectAttributes reAttr) {
		logger.info("updatePOST() ȣ��");
		int result = memberService.update(vo);
		if (result == 1) {
			logger.info(result + "�� ����");
			reAttr.addFlashAttribute("result", "updateSuccess");
			return "redirect:/main/member/mypage";
		} else {
			return "redirect:/main/member/update";
		}
	} // end updatePOST()
	
	@GetMapping("/delete")
	public void deleteGET() {
		logger.info("deleteGET() ȣ��");
	} // end deleteGET()
	
	@PostMapping("/delete")
	public String deletePOST(MemberVO vo, RedirectAttributes reAttr, HttpSession session) {
		logger.info("deletePOST() ȣ��");
		int result = memberService.delete(vo);
		if (result == 1) {
			logger.info(result + "�� ����");
			reAttr.addFlashAttribute("result", "deleteSuccess");
			session.removeAttribute("memberId");
			return "redirect:/main/main";
		} else {
			return "redirect:/main/member/delete";
		}
	} // end deletePOST()
	
	@GetMapping("/main")
	public String main() {
		logger.info("�������� ���� ȣ��");
		return "redirect:/main/main";
	} // end main()
} // end MemberController
