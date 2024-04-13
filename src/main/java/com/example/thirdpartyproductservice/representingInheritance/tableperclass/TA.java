package com.example.thirdpartyproductservice.representingInheritance.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tpc_ta")
public class TA extends User {
    private String avgRating;
    private String noOfSessions;
}
