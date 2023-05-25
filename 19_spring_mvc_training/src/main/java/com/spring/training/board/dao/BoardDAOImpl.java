package com.spring.training.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.training.board.dto.BoardDTO;

@Repository //db랑 엑세스 하는 애
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired //db에서 가져오기 
	private SqlSession sqlSession; //root-context.xml에서 가져온 것

	@Override
	public void insertBoard(BoardDTO boardDTO) throws Exception {
		sqlSession.insert("boardMapper.insertBoard", boardDTO);
		
	}

	@Override
	public List<BoardDTO> selectListBoard() throws Exception {
		//List<BoardDTO> boardList = sqlSession.selectList("boardMapper.selectListBoard");
		//return boardList;
		return sqlSession.selectList("boardMapper.selectListBoard");
		
	}

	@Override
	public void updateReadCnt(long boardId) throws Exception {
		sqlSession.update("boardMapper.updateReadCnt", boardId );
		
	}

	@Override
	public BoardDTO selectOneBoard(long boardId) throws Exception {
		
		
		return sqlSession.selectOne("boardMapper.selectOneBoard", boardId);
	}

	@Override
	public String selectOnePasswd(long boardId) throws Exception {
		
		return sqlSession.selectOne("boardMapper.selectOnePasswd", boardId);
	}

	@Override
	public void updateBoard(BoardDTO boardDTO) throws Exception {
		
		sqlSession.update("boardMapper.updateBoard", boardDTO);
		
		
	}

	@Override
	public void deleteBoard(long boardId) throws Exception {
		sqlSession.delete("boardMapper.deleteBoard", boardId);
		
	}
	
	
	
}
