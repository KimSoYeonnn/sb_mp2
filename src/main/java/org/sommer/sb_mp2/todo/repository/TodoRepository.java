package org.sommer.sb_mp2.todo.repository;

import org.sommer.sb_mp2.todo.entities.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    
    @Query("select t from Todo t where t.title = ?1") //SQL이 아님!!
    Page<Todo> listofTitle(String title, Pageable pageable);
}
