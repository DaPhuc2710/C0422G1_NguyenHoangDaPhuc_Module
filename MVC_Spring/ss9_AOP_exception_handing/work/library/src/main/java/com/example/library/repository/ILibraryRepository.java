package com.example.library.repository;

import com.example.library.model.BookManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface ILibraryRepository extends JpaRepository<BookManager, Integer> {
    @Modifying
    @Query(value = "update  library set remaining=remaining-1 where id =:id", nativeQuery = true)
    void borrowBook(@Param("id")Integer id);

    @Modifying
    @Query(value = "update  library set remaining=remaining+1 where id =:id",nativeQuery = true)
    void payBack(@Param("id")Integer id);
}
