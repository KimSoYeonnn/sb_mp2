package org.sommer.sb_mp2.todo.service;

import org.sommer.sb_mp2.todo.dto.TodoDTO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TodoService {
    
    TodoDTO getOne(Long tno);

}
