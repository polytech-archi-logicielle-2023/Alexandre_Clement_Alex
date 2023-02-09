package com.example.demo.model;
import lombok.*;
import javax.persistence.*; // import persistance library
// mvn clean spring-boot:run
// https://github.com/polytech-archi-logicielle-2023/tp-backend/tree/main/tp-backend-setup#backend-for-your-project
@Entity // mark class as a database entity
@Getter // specify separatly lombok annotation instead of @Data to avoid some problems
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users") // name of database table
public class User {

    @Id // annotation for ID column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // strategy for ID, here it well be ID++
    @Column(length = 11) // column size on database side definition
    private Integer id;

    @Column(name = "name", nullable = false, length = 45) // database definiton => will launch SQL exception
    // NB: words in name should be linked by underscore => name_of_column
    private String name;

    @Column(name = "password", length = 50)
    private String password;

    @Column(name = "email", length = 100)
    private String email;

}
