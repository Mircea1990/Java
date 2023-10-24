package com.example.spring.patterns.template;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

// The BookRowMapper class implements the RowMapper interface provided by Spring JDBC.
// It is used to map rows of a ResultSet on a per-row basis.
public class BookRowMapper implements RowMapper<Book> {
    // The mapRow method is overridden to define the mapping between the current row of the
    // ResultSet to a Book object.
    @Override public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        // A new Book object is created.
        Book book = new Book();
        // The 'id' field of the book is set using the 'id' column value from the current row of
        // the ResultSet.
        book.setId(rs.getLong("id"));
        // The 'title' field of the book is set using the 'title' column value from the current
        // row of the ResultSet.
        book.setTitle(rs.getString("title"));
        // The 'author' field of the book is set using the 'author' column value from the current
        // row of the ResultSet.
        book.setAuthor(rs.getString("author"));
        // The populated Book object is returned.
        return book;
    }
}

