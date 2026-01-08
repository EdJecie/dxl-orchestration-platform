package com.edna.dxl.billing.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class BillingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String status;
    private LocalDateTime createdAt = LocalDateTime.now();

}
