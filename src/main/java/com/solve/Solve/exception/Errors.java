package com.solve.Solve.exception;

public interface Errors {
    String ERR_INVALID_DATA_BLOG = "InvalidData: Invalid blog data given";
    String ERR_INCOMPLETE_JSON_BLOG_ID = "IncompleteJSON: ID must not be empty";
    String ERR_INCOMPLETE_JSON_BLOG_AUTHOR = "IncompleteJSON: Blog must have at-least one author";
    String ERR_INCOMPLETE_JSON_BLOG_AUTHOR_EMPTY = "IncompleteJSON: Empty string provided for author";
    String ERR_INCOMPLETE_JSON_BLOG_TITLE = "IncompleteJSON: Title must not be empty";
    String ERR_INCOMPLETE_JSON_BLOG_TEXT = "IncompleteJSON: Text must not be empty";
    String ERR_ENTITY_NOT_FOUND_BLOG_PREFIX = "Blog with ID ";
    String ERR_ENTITY_NOT_FOUND_BLOG_SUFFIX = " not found";

    String ERR_INCOMPLETE_JSON_COMMENT_ID = "IncompleteJSON: ID must not be empty";
    String ERR_INCOMPLETE_JSON_COMMENT_BLOG_ID = "IncompleteJSON: Blog ID must not be empty";
    String ERR_INCOMPLETE_JSON_COMMENT_AUTHOR = "IncompleteJSON: Comment must have an author";
    String ERR_INCOMPLETE_JSON_COMMENT_TEXT = "IncompleteJSON: Text must not be empty";

}
