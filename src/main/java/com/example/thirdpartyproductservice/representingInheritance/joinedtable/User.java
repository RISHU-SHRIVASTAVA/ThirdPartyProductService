package com.example.thirdpartyproductservice.representingInheritance.joinedtable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy= InheritanceType.JOINED)
@Entity(name="jt_user")
@PrimaryKeyJoinColumn(name = "user_id")
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
    private String password;

}
