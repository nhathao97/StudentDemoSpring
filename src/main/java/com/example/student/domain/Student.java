package com.example.student.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "STUDENT")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID" , unique = true, nullable = false)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "STUDENTID")
    private String studentID;

    @Column(name = "CREATED_AT")
    private LocalDate created_at;

}
