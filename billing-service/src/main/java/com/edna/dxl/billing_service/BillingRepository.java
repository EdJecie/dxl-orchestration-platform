package com.edna.dxl.billing.repository;

import com.edna.dxl.billing.entity.BillingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingRepository extends JpaRepository<BillingRecord, Long> {
}
