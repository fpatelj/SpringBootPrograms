package org.learn.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
//@Repository
//@Component
public class BookRepository {

	public static List<Book> BOOKS = new ArrayList<>(5);
	public static Map<Integer, Book> BOOKMAP = new HashMap<>(5);
	static {
		BOOKS.add(new Book(1001, "Harry Potter"));
		BOOKS.add(new Book(1002, "The old man and the saint"));
		BOOKS.add(new Book(1003, "Essentail java"));
		BOOKS.add(new Book(1004, "Essential Spring 5"));
		BOOKS.add(new Book(1005, "Harry Potter 3"));

		for (Book book : BOOKS) {
			BOOKMAP.put(book.getId(), book);
		}

	}

}
