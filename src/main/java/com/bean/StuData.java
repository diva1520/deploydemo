package com.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="student")
@Data
public class StuData {

    @Id
    private int studentID;

    private String name;

    @OneToOne(mappedBy = "student") // points to LibraryCard.student
    private LibraryCard card;
}
