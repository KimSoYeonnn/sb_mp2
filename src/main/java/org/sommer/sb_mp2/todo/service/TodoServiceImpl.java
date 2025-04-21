package org.sommer.sb_mp2.todo.service;

import org.sommer.sb_mp2.todo.dto.TodoDTO;
import org.sommer.sb_mp2.todo.entities.Todo;
import org.sommer.sb_mp2.todo.repository.TodoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class TodoServiceImpl implements TodoService {

    private final TodoRepository repository;

    @Override
    public Page<TodoDTO> getList(Pageable pageable) {
        log.info("Method Called!");

        Page<Todo> result = repository.findAll(pageable);

        return result.map(todo -> {
            log.info("Todo Entity: {}", todo);
            return TodoDTO.builder()
                    .tno(todo.getTno())
                    .title(todo.getTitle())
                    .writer(todo.getWriter())
                    .content(todo.getContent())
                    .regDate(todo.getRegDate())
                    .modDate(todo.getModDate())
                    .build();
        });
    }
    
}
