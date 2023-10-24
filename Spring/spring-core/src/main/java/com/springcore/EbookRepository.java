package com.springcore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// The @Repository annotation is used to indicate that the class provides the mechanism for
// storage, retrieval,
// search, update and delete operation on objects.
@Repository
// This interface extends JpaRepository, specifying the domain type as Ebook and the id type as
// Integer.
// JpaRepository is a JPA specific extension of Repository which contains methods for performing
// standard CRUD operations.
public interface EbookRepository extends JpaRepository<Ebook, Integer> {
    // This method signature is designed to retrieve the title of an Ebook given its id.
    // The implementation of this method will be automatically provided by Spring Data JPA.
    String titleById(int id);
}

