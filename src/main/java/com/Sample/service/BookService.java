package com.Sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.Sample.entity.Book;
import com.Sample.repository.BookRepository;

@Service
public class BookService 
{
	@Autowired
	private BookRepository bRepo;
	
    public void save(Book b)
    {
    	bRepo.save(b);
    }

	public List<Book> getAllBook() 
	{
		return bRepo.findAll();
	}

	public Book getBookById(int id)
	{
		return bRepo.findById(id).get();
	}

	

	
}
