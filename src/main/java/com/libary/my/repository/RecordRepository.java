package com.libary.my.repository;

import com.libary.my.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RecordRepository extends JpaRepository<Record, UUID> {

    @Query("SELECT r FROM Record r WHERE r.bookId = :bookId AND r.status = :status")
    Optional<Record> findByBookIdAndStatus(@Param("bookId") UUID bookId, @Param("status") Integer status);
}
