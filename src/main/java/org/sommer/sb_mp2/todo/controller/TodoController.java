package org.sommer.sb_mp2.todo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;

import org.sommer.sb_mp2.todo.dto.ActionResultDTO;
import org.sommer.sb_mp2.todo.dto.TodoDTO;
import org.sommer.sb_mp2.todo.entities.Todo;
import org.sommer.sb_mp2.todo.repository.TodoRepository;
import org.sommer.sb_mp2.todo.service.TodoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/v1/todos")
@Log4j2
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    private final TodoRepository repository;

    @GetMapping("list")
    public ResponseEntity<Page<TodoDTO>> getList(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page - 1, size, Sort.by("tno").descending());

        Page<TodoDTO> result = todoService.getList(pageable);

        return ResponseEntity.ok(result);
    }
  
    @GetMapping("/read/{tno}")
    public ResponseEntity<TodoDTO> read(@PathVariable("tno") Long tno) {
        log.info("읽기 요청 : {}", tno);
        TodoDTO dto = todoService.getOne(tno);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("")
    public ResponseEntity<ActionResultDTO<Long>> post(TodoDTO dto){

        log.info("----------------post--------------------");
        log.info(dto);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Todo todo = Todo.builder()
                        .title(dto.getTitle())
                        .writer(dto.getWriter())
                        .content(dto.getContent())
                        .build();
            
        Todo saved = repository.save(todo);

        return ResponseEntity.ok(ActionResultDTO.<Long>builder()
                        .result("success")
                        .data(saved.getTno())
                .build());

    }
        
}
