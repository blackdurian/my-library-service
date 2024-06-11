package com.libary.my.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="record")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Record implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name="borrower_id", columnDefinition = "BINARY(16)")
    private UUID borrowerId;

    @Column(name="book_id", columnDefinition = "BINARY(16)")
    private UUID bookId;

    @Column(name = "status")
    private Integer status;

    @Column(name = "borrow_time")
    private LocalDateTime borrowTime;

    @Column(name = "return_time")
    private LocalDateTime returnTime;
}
