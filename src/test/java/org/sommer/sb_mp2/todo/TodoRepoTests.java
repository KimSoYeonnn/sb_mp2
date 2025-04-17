package org.sommer.sb_mp2.todo;

import org.junit.jupiter.api.Test;
import org.sommer.sb_mp2.todo.entities.Todo;
import org.sommer.sb_mp2.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class TodoRepoTests {
    
    @Autowired(required = false)
    private TodoRepository repository;

    @Test
    public void testInsert() {
        
        Todo todo = Todo.builder()
            .title("Test")
            .writer("user1")
            .build();

        repository.save(todo);
    }
}
