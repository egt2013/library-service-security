package com.sample.library.model;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="book")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String author;
    private String category;
    private int rateScore;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate = new Date();;
}
