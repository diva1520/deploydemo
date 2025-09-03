package com.bean;

import org.springframework.stereotype.Component;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Component
@Entity
@Table(name="library")
@Data
public class LibraryCard {
    
    @Id
    private int libraryID;

    @OneToOne
    @JoinColumn(name = "student_id") // explicit column name
    private StuData student; // rename from studentID to student

    private String book;
}
