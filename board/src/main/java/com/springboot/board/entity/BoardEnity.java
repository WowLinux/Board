package com.springboot.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

//DB의 테이블 역할을 하는 클래스
@Entity
@Getter
@Setter
@Table(name ="board_table1")
public class BoardEnity {

	@Id //PK 컬럼지정, 필수
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
	private Long id;
	
	@Column(length = 20, nullable =false) //크기는 20 , not null
	private String boardWriter;
	
// 	@Column(unique = true)  //크기 255, null 가능상태 가 기본이다. Unique도 줄 수있다.
	
}