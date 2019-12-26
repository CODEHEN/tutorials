package org.example.models;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "t_student")
public class Student implements Serializable {
    private static final long serialVersionUID = -3009157732242241606L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String studentName;

}
