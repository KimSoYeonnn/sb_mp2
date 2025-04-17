package org.sommer.sb_mp2.todo.repository;

import org.sommer.sb_mp2.todo.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    
}
