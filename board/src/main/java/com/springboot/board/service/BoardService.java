package com.springboot.board.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.springboot.board.dto.BoardDTO;
import com.springboot.board.entity.BoardEntity;
import com.springboot.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;


/*Jpa경우는 Repository가 기본적으로 Entity를 받기 때문에
//Service에서 Repository로 넘어갈때 DTO->Entity로 변경하거나
//Repository에서 Service로 올때 Entity->DTO로 변경해야 한다.
//즉 Controller로 부터 호출을 받을때 DTO로 넘겨 받고 Repostitory로 넘겨 줄때는 Entity로 넘겨준다.
//DB로 부터 데이터를 조회 할 때는 Reppository로 부터 Entity로 받아오고 이 Entity를 Controller로 넘겨 줄때는 DTO로 넘겨 준다는 이야기 이다.

//Entity -> DTO(DTO Class) */

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;
	public void save(BoardDTO boardDTO) {
		BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDTO);
		boardRepository.save(boardEntity);
		
	}
	public List<BoardDTO> findAll() {
	List<BoardEntity> boardEntityList	= boardRepository.findAll();
	List<BoardDTO> boardDTOList = new ArrayList<>();
		for (BoardEntity boardEntity : boardEntityList) {
			    boardDTOList.add(BoardDTO.toBoardDTO(boardEntity));
		}
		return boardDTOList;
	}
	
	@Transactional
	public void updateHits(Long id) {
		boardRepository.updateHits(id);
		
	}
	public BoardDTO findById(Long id) {
		Optional<BoardEntity> optionalBoardEntiry =  boardRepository.findById(id);
		if (optionalBoardEntiry.isPresent()) {
			BoardEntity boardEntity = optionalBoardEntiry.get();
			BoardDTO boardDTO = BoardDTO.toBoardDTO(boardEntity);
			return boardDTO;
		} else {
			return null;			
		}
	}
}
