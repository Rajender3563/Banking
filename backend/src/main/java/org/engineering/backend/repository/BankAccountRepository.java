package org.engineering.backend.repository;

import org.engineering.backend.entity.BankAccount;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface BankAccountRepository extends CassandraRepository<BankAccount, UUID> {
    // Custom queries can be added here if needed, e.g., findByAccountNumber
}