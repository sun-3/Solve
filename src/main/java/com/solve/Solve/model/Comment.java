package com.solve.Solve.model;

import com.solve.Solve.exception.Errors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = Errors.ERR_INCOMPLETE_JSON_COMMENT_ID)
    private int id;

    private int parentId;

    @NotNull(message = Errors.ERR_INCOMPLETE_JSON_COMMENT_BLOG_ID)
    private int blogId;

    @NotNull(message = Errors.ERR_INCOMPLETE_JSON_COMMENT_AUTHOR)
    @Size(min = 1, message = Errors.ERR_INCOMPLETE_JSON_COMMENT_AUTHOR)
    private String author;

    @NotNull(message = Errors.ERR_INCOMPLETE_JSON_COMMENT_TEXT)
    @Size(min = 1, message = Errors.ERR_INCOMPLETE_JSON_COMMENT_TEXT)
    private String text;

    private Date postedAt;
}
