package com.spring.training.board.dao;

import java.util.List;

import com.spring.training.board.dto.BoardDTO;

//@는 class한테 주는 것.
public interface BoardDAO {
	
	
	public void insertBoard(BoardDTO boardDTO) throws Exception;
	
	public List<BoardDTO> selectListBoard() throws Exception;
	
	public void updateReadCnt(long boardId) throws Exception;
	public BoardDTO selectOneBoard(long boardId) throws Exception;
	
	public String selectOnePasswd(long boardId) throws Exception;
	public void updateBoard(BoardDTO boardDTO) throws Exception;
	
	
	public void deleteBoard(long boardId) throws Exception;
}