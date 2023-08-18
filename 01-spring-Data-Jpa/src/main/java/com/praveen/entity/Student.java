package com.praveen.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name="tbl_Student",
        uniqueConstraints = @UniqueConstraint(
                name="emailAddress_unique",
                columnNames = "email_address"
        )

)
public class Student {
    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String firstName;
    private String lastName;
    @Column(name="email_address")
    private String emailName;

   @Embedded
    private Guardian guardian;

    public static StudentBuilder builder() {
        return new StudentBuilder();
    }

    public String toString() {
        return "Student(id=" + this.getId() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", emailName=" + this.getEmailName() + ", guardian=" + this.getGuardian() + ")";
    }


    public static class StudentBuilder {
        private Long id;
        private String firstName;
        private String lastName;
        private String emailName;
        private Guardian guardian;

        StudentBuilder() {
        }

        public StudentBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public StudentBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public StudentBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public StudentBuilder emailName(String emailName) {
            this.emailName = emailName;
            return this;
        }

        public StudentBuilder guardian(Guardian guardian) {
            this.guardian = guardian;
            return this;
        }

        public Student build() {
            return new Student(id, firstName, lastName, emailName, guardian);
        }

        public String toString() {
            return "Student.StudentBuilder(id=" + this.id + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", emailName=" + this.emailName + ", guardian=" + this.guardian + ")";
        }
    }
}
