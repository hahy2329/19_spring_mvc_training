package com.spring.training.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.training.board.dto.BoardDTO;
import com.spring.training.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	
	
	@Autowired
	private BoardService boardService;
	
	
	@GetMapping("/addBoard")
	public ModelAndView addBoard() {
		
	//	ModelAndView mv = new ModelAndView();
	//	mv.setViewName("board/addBoard");
	//	return mv;
		
		
		return new ModelAndView("board/addBoard");//servlet-context.xml prefix, suffix 사이 경로 적기 
		
	}
	
	@PostMapping("/addBoard")
	@ResponseBody
	public String addBoard(@ModelAttribute BoardDTO boardDTO) {
		
		
		//System.out.println(boardDTO);
		
		boardService.addBoard(boardDTO);
		
		String jsScript = "<script>";
		jsScript += "alert('Post Added');";
		jsScript +="location.href='addBoard';";
		
		jsScript +="</script>";
		
		return jsScript;
	}
	
	@GetMapping("/boardList")
	public ModelAndView boardList(){
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardList");
		
		//List<BoardDTO> boardList = boardService.getBoardList();
		//mv.addObject("boardList","boardList");
		
		
		List<BoardDTO> boardList = boardService.getBoardList();
		
		for(BoardDTO boardDTO : boardList) {
			System.out.println(boardDTO);
		}
		
		
		
		mv.addObject("boardList",boardService.getBoardList());
		
		
		
		
		return mv;
	}
	
	
	
	
	
	
	
}
