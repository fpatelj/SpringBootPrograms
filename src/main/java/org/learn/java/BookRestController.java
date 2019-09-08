package org.learn.java;

import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rest")

public class BookRestController {

	List<Book> books = BookRepository.BOOKS;
	Map<Integer, Book> bookMap = BookRepository.BOOKMAP;

	@GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Book>> getAll() {
		List<Book> books = BookRepository.BOOKS;
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	@GetMapping(value = "/books/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Book> getOne(@PathVariable Integer id) {
		Book book = bookMap.get(id);

		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@PostMapping(value = "/books/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> createOrAdd(@RequestBody ( required = true) Book book) {
		books.add(book);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
