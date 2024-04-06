package com.example.thirdpartyproductservice.representingInheritance.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="msc_ta")
public class TA extends User {
    private String avgRating;
    private String noOfSessions;
}
