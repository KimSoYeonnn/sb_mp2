package org.sommer.sb_mp2.todo;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.sommer.sb_mp2.todo.entities.Todo;
import org.sommer.sb_mp2.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    @Commit
    public void testInsertOne() {

        Todo todo = Todo.builder()
            .title("Test")
            .writer("user00")
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

    @Test
    public void testList() {

        Pageable pageable 
        = PageRequest.of(0, 10, Sort.by("tno").descending());

        Page<Todo> result = repository.findAll(pageable);

        result.get().forEach(todo -> log.info(todo));

        log.info("-------------------------");
        log.info(result.getTotalElements());
        log.info(result.getNumber());
        log.info(result.getSize());

    }


    @Test
    public void testQuery1() {

    Pageable pageable = PageRequest.of(0, 10, Sort.by("tno").descending());

    repository.listofTitle("tle", pageable);

  }
}
