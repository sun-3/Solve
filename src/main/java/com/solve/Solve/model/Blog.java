package com.solve.Solve.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    private int id;
    private String[] authors;
    private String title;
    private String text;
    private Date postedAt;
}
