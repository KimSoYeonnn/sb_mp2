package org.sommer.sb_mp2.todo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tbl_todo")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Todo extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tno;

    @Column(nullable = false, length = 300)
    private String title;

    private String writer;

    private String content;

    public void changeTitle(String title){
        this.title = title;
      }

}
