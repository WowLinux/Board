package com.springboot.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.board.dto.BoardDTO;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@Controller
@RequestMapping("/board")
public class BoardController {
	@GetMapping("/save")
	public String saveForm() {
		return "save";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute BoardDTO boardDTO) {
		System.out.println("boardDTO = " + boardDTO);
		
		return "list";
	}
}
