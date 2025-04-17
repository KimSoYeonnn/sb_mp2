package org.sommer.sb_mp2.todo;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.sommer.sb_mp2.todo.entities.Todo;
import org.sommer.sb_mp2.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
@Transactional
public class TodoRepoTests {
    
    @Autowired(required = false)
    private TodoRepository repository;

    @Test
    public void testInsertOne() {

        Todo todo = Todo.builder()
            .title("Test")
            .writer("user1")
            .build();

        repository.save(todo);
    }

    @Test
    @Commit
    public void testInsert() {

        for (int i = 1; i <= 25; i++) {
            
            Todo todo = Todo.builder()
                .title("Test" + i)
                .writer("user" + i )
                .build();
    
            repository.save(todo);
        }

    }

    @Test
    public void testRead() {

        Optional<Todo> result = repository.findById(1L);

        log.info("---------Test Read-------");
        log.info(result.get());
    }

    @Test
    @Commit
    public void testDelete() {

        Long tno = 26L;

        repository.deleteById(tno);
    }

    @Test
    @Commit
    public void testUpdate(){

        java.util.Optional<Todo> result = repository.findById(1L);

        Todo todo = result.get();

        todo.changeTitle("Changed Title234");

        //repository.save(todo);
    }




}
