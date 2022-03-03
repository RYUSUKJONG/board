package com.home.board.service;

import com.home.board.entity.Board;
import com.home.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class BoardService {


    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void write(Board board){

        boardRepository.save(board);
    }


    public List<Board> boardList(){
        return boardRepository.findAll();
    }



    public Board boardView(Integer id) {
        if(boardRepository.findById(id).isPresent()) {
            return boardRepository.findById(id).get();
        } else {
            return new Board();
        }
    }
    
    
    //특정 게시글 삭제
    public void boardDelete(Integer id){

        boardRepository.deleteById(id);

    }


}
