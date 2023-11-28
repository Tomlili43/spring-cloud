package com.dailycodebuffer.departmentservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "`id`")
    private Long id;
    @Column(name = "`customer_name`")
    private String customerName;
    @Column(name = "`product`")
    private String product;

    // add column status default value to "CREATED"
    @Column(name = "`status`", columnDefinition = "varchar(30) default 'CREATED'")
    private String status;

    // getters and setters
}