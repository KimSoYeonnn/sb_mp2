package org.sommer.sb_mp2.todo.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@Getter
public class TodoDTO {
    
    private Long tno;

    private String title;

    private String writer;

    private String content;

    private LocalDateTime regDate;
    private LocalDateTime modDate;

    public TodoDTO(Long tno, String title, String writer, String content, LocalDateTime regDate,
            LocalDateTime modDate) {
        this.tno = tno;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.regDate = regDate;
        this.modDate = modDate;
    }


    
}
