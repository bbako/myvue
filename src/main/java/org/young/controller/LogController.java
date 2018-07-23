package org.young.controller;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.young.domain.MemberVO;
import org.young.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/log/*")
public class LogController {

	private static final Logger logger = LoggerFactory.getLogger(LogController.class);

	@Inject
	MemberService mservice;


	@GetMapping("/login")
	public void login() throws Exception {
		logger.info("login one");
	}

	@PostMapping("/loginPost")
	public void loginPOST(MemberVO dto,HttpSession session, Model model) throws Exception{

		logger.info("==============================================================================");
		logger.info("Login Post !!!!!!!!");
		logger.info(dto.toString());

		MemberVO vo = mservice.login(dto);

		if(vo == null ){return; }

		model.addAttribute("MemberVO", vo);

		if(dto.isUseCookie()){

			logger.info("remember me checked");

			int amount = 60*60*24*7;
			Date sessionLimit = new Date(System.currentTimeMillis()+(1000*amount));

			dto.setSessionKey(session.getId());
			dto.setSessionLimit(sessionLimit);

			mservice.keepLogin(dto);

		}

	}


}
