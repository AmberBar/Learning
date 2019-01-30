package com.amber.pojo;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "table_user")
@Data
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer age;
    private String address;


}
