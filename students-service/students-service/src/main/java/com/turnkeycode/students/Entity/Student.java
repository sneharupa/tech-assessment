package com.turnkeycode.students.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;
    private Integer courseId;

    @ManyToMany
    @JoinTable(
            name = "Student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private Set<Courses> courses = new HashSet<>();

}
