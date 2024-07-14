package com.springboot.board.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.board.dto.BoardDTO;
import com.springboot.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
	
	private final BoardService boardService;
	
	@GetMapping("/save")
	public String saveForm() {
		return "save";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute BoardDTO boardDTO) {
		System.out.println("boardDTO = " + boardDTO);
		boardService.save(boardDTO);
		return "index";
	}
	
	//DB로 부터 Data를 가져와야 한다면 Model 객체를 이용한다.
	
	@GetMapping("/")
	public String findAll(Model model) {
		// DB에서 전체 게시글 데이터를 가져와서 list.html에 보여준다.
		List<BoardDTO> boardDTOList = boardService.findAll();
		model.addAttribute("boardList", boardDTOList);
		return "list";
	}
	
	@GetMapping("/{id}")
	public String findById(@PathVariable Long id, Model model) {
		/*
		 * 해당 게시글의 조회수를 하나 올리고
		 * 게시글 데이터를 가져와서 detal.html에 출력
		 */
		boardService.updateHits(id);
		BoardDTO boardDTO = boardService.findById(id);
		model.addAttribute("board", boardDTO);
		return "detail";
	}
	
}
