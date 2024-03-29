package com.spring.training.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.training.board.dao.BoardDAO;
import com.spring.training.board.dto.BoardDTO;


/*

패스워드 암호화

1) pom.xml파일에 dependency를 추가한다.

	<dependency>
	    <groupId>org.springframework.security</groupId>
	    <artifactId>spring-security-web</artifactId>
	    <version>5.0.8.RELEASE</version>
	</dependency>
	
	<dependency>
	    <groupId>org.springframework.security</groupId>
	    <artifactId>spring-security-config</artifactId>
	    <version>5.0.8.RELEASE</version>
	</dependency>

2) servlet-context.xml에 아래의 빈 선언을 추가한다.

	<beans:bean id="bcryptPasswordEncoder" class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder" /> 


3) 서비스 로직에서 BCryptPasswordEncoder 객체를 생성한다.

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

4) 사용법

	- bCryptPasswordEncoder.encode(암호화하고 싶은 패스워드)   				// encode(평문)메서드를 통하여 패스워드를 암호화한다.
	- bCryptPasswordEncoder.matches(입력받은 패스워드, 암호화된 패스워드) 	// matches(평문,암호문) 메서드를 통하여 입력받은 패스워드와 암호화된 패스워드를 비교한다.
	- 암호화된 패스워드를 복호화하는 메서드는 존재하지 않는다.		

*/


@Service
public class BoardServiceImpl implements BoardService  {

	@Autowired //인터페이스 BoardDAO를 가져온다.
	private BoardDAO boardDAO;
	
	@Autowired //패스워드 암호화
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	

	@Override
	public void addBoard(BoardDTO boardDTO) throws Exception {
		
	
		
		boardDTO.setPasswd(bCryptPasswordEncoder.encode(boardDTO.getPasswd()));
		//패스워드 암호화 후 다시 적재
		
		boardDAO.insertBoard(boardDTO);
		
	}


	@Override
	public List<BoardDTO> getBoardList() throws Exception {
		
		//List<BoardDTO> boardList = boardDAO.selectListBoard();
		
		//return boardList;
		
		return boardDAO.selectListBoard();
		
	}


	@Override
	@Transactional//이유는 if문절에 update가 가능해도 밑에줄에 오류가 발생하면 실행이 되어선 안된다.
	public BoardDTO getBoardDetail(long boardId, boolean isUpdateReadCnt) throws Exception {
		
		
		if(isUpdateReadCnt == true) {
			boardDAO.updateReadCnt(boardId);
			//~~~~~~~이쪽에 오류가 난다면?
		}
		
		
		
		return boardDAO.selectOneBoard(boardId);
	}


	@Override
	@Transactional
	public boolean modifyBoard(BoardDTO boardDTO) throws Exception {
		boolean isUpdate = false;
		
		if(bCryptPasswordEncoder.matches(boardDTO.getPasswd(), boardDAO.selectOnePasswd(boardDTO.getBoardId()))) { //서로 비교
			boardDAO.updateBoard(boardDTO);
			isUpdate = true;
		
		}
		
		return isUpdate;
	}


	@Override
	@Transactional
	public boolean removeBoard(BoardDTO boardDTO) throws Exception {
		boolean isDelete = false;
		
		String encodedPassword = boardDAO.selectOnePasswd(boardDTO.getBoardId());
		
		boolean isValid = bCryptPasswordEncoder.matches(boardDTO.getPasswd(), encodedPassword);
		
		if(isValid) {
			boardDAO.deleteBoard(boardDTO.getBoardId());
			isDelete = true;
		}
		
		return isDelete;
	}
	
	
	
	
}
