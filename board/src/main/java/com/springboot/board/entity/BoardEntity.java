package com.springboot.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.springboot.board.dto.BoardDTO;

import lombok.Getter;
import lombok.Setter;

//DB의 테이블 역할을 하는 클래스
@Entity
@Getter
@Setter
@Table(name ="board_table1")
public class BoardEntity  extends BaseEntity {

	@Id //PK 컬럼지정, 필수
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
	private Long id;
	
	@Column(length = 20, nullable =false) //크기는 20 , not null
	private String boardWriter;
	
// 	@Column(unique = true)  //크기 255, null 가능상태 가 기본이다. Unique도 줄 수있다.
	@Column
	private String boardPass;
	
	@Column
	private String boardTitle;
	
	@Column(length = 500)
	private String boardContents;
	
	@Column
	private int boardHits;
	
	public static BoardEntity toSaveEntity(BoardDTO boardDTO) {
		BoardEntity boardEntity = new BoardEntity();
		boardEntity.setBoardWriter(boardDTO.getBoardWriter() );
		boardEntity.setBoardPass(boardDTO.getBoardPass());
		boardEntity.setBoardTitle(boardDTO.getBoardTitle());
		boardEntity.setBoardContents(boardDTO.getBoardContents());
		boardEntity.setBoardHits(0);
		return boardEntity;
	}
	
}
