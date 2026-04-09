package com.example.demo.board.repository;

import com.example.demo.board.domain.BoardPost;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardPostRepository extends JpaRepository<BoardPost, Long> {

    List<BoardPost> findAllByOrderByIdxDesc();
}
