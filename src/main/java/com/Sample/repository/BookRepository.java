package com.Sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Sample.entity.Book;

public interface BookRepository extends JpaRepository<Book,Integer>
{

}
