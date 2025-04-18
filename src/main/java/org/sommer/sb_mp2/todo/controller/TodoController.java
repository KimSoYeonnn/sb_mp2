package org.sommer.sb_mp2.todo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;

import org.sommer.sb_mp2.todo.dto.TodoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/todos")
@Log4j2
@RequiredArgsConstructor
public class TodoController {
  
    @GetMapping("list")
    public ResponseEntity<List<TodoDTO>> getList() {
        
        List<TodoDTO> list = List.of(
                                    TodoDTO.builder()
                                            .tno(10L)
                                            .title("Test10")
                                            .writer("user10")                                            
                                    .build()

        );

        return ResponseEntity.ok(list);
    }
    
}
