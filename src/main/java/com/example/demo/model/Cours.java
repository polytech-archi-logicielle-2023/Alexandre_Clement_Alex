package com.example.demo.model;
import lombok.*;
import javax.persistence.*; // import persistance library

@Entity // mark class as a database entity
@Getter // specify separatly lombok annotation instead of @Data to avoid some problems
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cours") // name of database table
public class Cours {

    @Id // annotation for ID column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // strategy for ID, here it well be ID++
    @Column(length = 11) // column size on database side definition
    private Integer id;

    @Column(name = "Nom_du_cours", nullable = false, length = 45) // database definiton => will launch SQL exception
    // NB: words in name should be linked by underscore => name_of_column
    private String Nom_du_cours;

    @Column(name = "Enseignant", length = 50)
    private String Enseignant;

    @Column(name = "Type", length = 20)
    private String Type;

}
