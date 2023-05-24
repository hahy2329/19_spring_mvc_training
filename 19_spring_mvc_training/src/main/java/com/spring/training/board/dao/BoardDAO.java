package com.spring.training.board.dao;

import java.util.List;

import com.spring.training.board.dto.BoardDTO;

//@는 class한테 주는 것.
public interface BoardDAO {
	
	
	public void insertBoard(BoardDTO boardDTO);
	
	public List<BoardDTO> selectListBoard();
	
	public void updateReadCnt(long boardId);
	public BoardDTO selectOneBoard(long boardId);
	
	public String selectOnePasswd(long boardId);
	public void updateBoard(BoardDTO boardDTO);
	
	
	public void deleteBoard(long boardId);
}