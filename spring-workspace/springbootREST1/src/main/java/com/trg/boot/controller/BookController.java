package com.trg.boot.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trg.boot.model.Book;
import com.trg.boot.model.Author;
import com.trg.boot.model.Employee;

@RestController
@RequestMapping("books")
public class BookController {

	static Map<Integer, Book> bookData;
	
	
	
	static {
		Author a1 = new Author(101,"Arthur","New Delhi");
		Author a2 = new Author(102,"Arushi","Mumbai");
		
		
		bookData = new HashMap<Integer, Book>();

		bookData.put(100, new Book(100, "Spring-boot", a1));
		bookData.put(200, new Book(200, "Harry potter", a2));
		bookData.put(300, new Book(300, "JavaScript basics", a1));
		bookData.put(400, new Book(400, "React", a2));
	}
	
	@RequestMapping("{bid}")
	public Book getBook(@PathVariable("bid") int bookid){
		
		Book b = bookData.get(bookid);
		
		return b;
		
	}
	
	@RequestMapping()
	public Collection<Book> getAllBooks() {
		Collection<Book> col = bookData.values();
		
		return col;
	}
	
	@RequestMapping("{bid}/author")
	public Author getAuthor(@PathVariable("bid") int bookId)
	{
		return bookData.get(bookId).getAuth();
	}
	
	
	
	
}
