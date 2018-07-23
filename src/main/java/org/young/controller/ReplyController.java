package org.young.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.young.domain.ReplyVO;
import org.young.service.ReplyService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/replies")
public class ReplyController {


	@Inject
	private ReplyService service;

	@RequestMapping(value="" , method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody ReplyVO vo) {
		ResponseEntity<String> entity = null;
		try {
			service.regist(vo);
			entity = new ResponseEntity<String>("success",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		
		return entity ;
	}
	
	@GetMapping("/all/{bno}")
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("bno") Integer bno){
		ResponseEntity<List<ReplyVO>> entity = null;
		try {
			entity = new ResponseEntity<>(service.listAll(bno),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity ;
	}
	
	@PutMapping("/{rno}")
	public ResponseEntity<String> update(@PathVariable("rno") Integer rno, @RequestBody ReplyVO vo){
		ResponseEntity<String> entity = null;
		
		vo.setRno(rno);
		try {
			service.modify(vo);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity ;
		
	}
	@DeleteMapping("/{rno}")
	public ResponseEntity<String> delete(@PathVariable("rno") Integer rno){
		ResponseEntity<String> entity = null;
		
		try {
			service.remove(rno);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity ;
		
	}

}
