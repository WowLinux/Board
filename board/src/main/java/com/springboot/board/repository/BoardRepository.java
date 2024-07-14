package com.springboot.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.board.entity.BoardEntity;

public interface BoardRepository  extends JpaRepository<BoardEntity, Long> {

	// update board_table set board_hits = board_hits+1 where id=?  이런 sql을 Jpa-Data에서 정의를 한다면.
	//
	@Modifying
	@Query(value="update BoardEntity b set  b.boardHits=b.boardHits+1 where b.id=:id")
	void updateHits(@Param("id") Long id);
	
	
	
	
}
