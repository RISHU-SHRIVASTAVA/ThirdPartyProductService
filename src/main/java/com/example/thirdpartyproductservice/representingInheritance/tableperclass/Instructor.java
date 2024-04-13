package com.example.thirdpartyproductservice.representingInheritance.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tpc_ist")
public class Instructor extends User{
    private String specialization;
}
