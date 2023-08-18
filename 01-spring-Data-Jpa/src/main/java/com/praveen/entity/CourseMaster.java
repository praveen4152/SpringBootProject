package com.praveen.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "course")
@Builder
public class CourseMaster {

    @Id
    @SequenceGenerator(
            name="course_master_sequence",
            sequenceName = "course_master_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_master_sequence"
    )
    private Long courseMasterId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL ,
            fetch = FetchType.LAZY,
            optional = false

    )
    @JoinColumn(
            name = "course_Id" ,
            referencedColumnName = "courseId"
    )
    private  Course course ;
}
