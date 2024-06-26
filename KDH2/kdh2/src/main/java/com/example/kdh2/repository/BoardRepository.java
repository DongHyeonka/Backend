package com.example.kdh2.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.kdh2.entity.BoardEntity;

@Repository
public class BoardRepository {
    private HashMap<Long, BoardEntity> store = new HashMap<>();
    private Long sequence = 0L;

    public BoardEntity save(BoardEntity boardEntity) {
        if(boardEntity.getId() == null) {
            boardEntity.setId(++sequence);
        }
        store.put(boardEntity.getId(), boardEntity);
        return boardEntity;
    }

    public BoardEntity findById(Long id) {
        return store.get(id);
    }

    public void delete(Long id) {
        store.remove(id);
    }

    public List<BoardEntity> AllBoards() {
        return new ArrayList<>(store.values());
    }
}
