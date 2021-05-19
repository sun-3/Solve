package com.solve.Solve.exception;

public interface Errors {
    String ERR_INCOMPLETE_JSON_BLOG_ID = "IncompleteJSON: ID must not be empty";
    String ERR_INCOMPLETE_JSON_BLOG_AUTHOR = "IncompleteJSON: Blog must have at-least one author";
    String ERR_INCOMPLETE_JSON_BLOG_TITLE = "IncompleteJSON: Title must not be empty";
    String ERR_INCOMPLETE_JSON_BLOG_TEXT = "IncompleteJSON: Text must not be empty";

    String ERR_INCOMPLETE_JSON_COMMENT_ID = "IncompleteJSON: ID must not be empty";
    String ERR_INCOMPLETE_JSON_COMMENT_BLOG_ID = "IncompleteJSON: Blog ID must not be empty";
    String ERR_INCOMPLETE_JSON_COMMENT_AUTHOR = "IncompleteJSON: Comment must have an author";
    String ERR_INCOMPLETE_JSON_COMMENT_TEXT = "IncompleteJSON: Text must not be empty";

}
