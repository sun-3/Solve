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
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = Errors.ERR_INCOMPLETE_JSON_BLOG_ID)
    private int id;

    @NotNull(message = Errors.ERR_INCOMPLETE_JSON_BLOG_AUTHOR)
    private String[] authors;

    @NotNull(message = Errors.ERR_INCOMPLETE_JSON_BLOG_TITLE)
    private String title;

    @NotNull(message = Errors.ERR_INCOMPLETE_JSON_BLOG_TEXT)
    private String text;

    @NotNull
    private Date postedAt;
}
