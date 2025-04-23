package org.sommer.sb_mp2.todo.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.sommer.sb_mp2.todo.dto.TodoDTO;
import org.sommer.sb_mp2.todo.entities.Todo;
import org.sommer.sb_mp2.todo.repository.TodoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public TodoDTO getOne(Long tno) {
        
        Optional<Todo> result = repository.findById(tno);

        Todo todo = result.orElseThrow(() -> new RuntimeException("해당 번호의 Todo가 없습니다."));

        return TodoDTO.builder()
            .tno(todo.getTno())
            .title(todo.getTitle())
            .content(todo.getContent())
            .writer(todo.getWriter())
            .regDate(todo.getRegDate())
            .modDate(todo.getModDate())
            .build();
    }

    @Override
    @Transactional
    public TodoDTO modify(TodoDTO dto) {

        Optional<Todo> result = repository.findById(dto.getTno());

        if (result.isEmpty()) {
            throw new IllegalArgumentException("해당 번호의 Todo가 존재하지 않습니다.");
        }

        Todo todo = result.get();

        todo.changeTitle(dto.getTitle());
        todo.changeContent(dto.getContent());
        todo.changeModDate(LocalDateTime.now());

        repository.save(todo);

        return TodoDTO.builder()
            .tno(todo.getTno())
            .title(todo.getTitle())
            .content(todo.getContent())
            .writer(todo.getWriter())
            .regDate(todo.getRegDate())
            .modDate(todo.getModDate())
            .build();
    }

    @Override
    @Transactional
    public void remove(Long tno) {
        repository.deleteById(tno);
    }
    
}
