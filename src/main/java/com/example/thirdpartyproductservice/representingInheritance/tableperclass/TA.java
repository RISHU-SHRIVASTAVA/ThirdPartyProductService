package com.example.thirdpartyproductservice.representingInheritance.tableperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TA extends User {
    private String avgRating;
    private String noOfSessions;
}
