package com.jwt.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jwt.entity.Books;

@Repository
public interface BookDao extends CrudRepository<Books, Long>{
//	@Query("update Books b set b.bookAvailable=b.bookAvailable-1 where b.Id=:id")
//	Books updateBookAvailable(@Param("bookAvailable") int bookAvailable,@Param("id") long id);
}
