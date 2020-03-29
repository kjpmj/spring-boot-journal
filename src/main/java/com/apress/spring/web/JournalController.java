package com.apress.spring.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apress.spring.domain.Journal;
import com.apress.spring.repository.JournalRepository;
import com.apress.spring.vo.TestVo;

@Controller
public class JournalController {

	@Autowired
	JournalRepository repo;
	
	@RequestMapping(value="/journal") 
	public @ResponseBody List<Journal> getJournal() {
		System.out.println("GET Journal");
		return repo.findAll();
	}
	
	@RequestMapping(value="/") 
	public @ResponseBody String getMsg(@RequestBody TestVo vo) {
		System.out.println("call getMsg");
		return "받은 파라미터들: " + vo.getClassName() + "  " + vo.getMethod();
	}
	
	@RequestMapping(value="/testvo") 
	public @ResponseBody TestVo getTestVo(@RequestBody TestVo vo) {
		System.out.println("call getTestVo");
		return vo;
	}
}
