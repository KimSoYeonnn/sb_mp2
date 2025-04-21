package org.sommer.sb_mp2.todo.service;

import org.sommer.sb_mp2.todo.dto.TodoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface TodoService {
    
    // TodoDTO getOne(Long tno);

    Page<TodoDTO> getList(Pageable pageable);

}
