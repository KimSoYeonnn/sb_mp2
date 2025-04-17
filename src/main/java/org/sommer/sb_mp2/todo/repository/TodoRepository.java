package org.sommer.sb_mp2.todo.repository;

import org.sommer.sb_mp2.todo.entities.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    
    @Query("select t from Todo t where t.title like %:title% ")
    Page<Todo> listofTitle( @Param("title") String title, Pageable pageable);
}
