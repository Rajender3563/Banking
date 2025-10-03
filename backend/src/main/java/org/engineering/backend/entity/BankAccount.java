package org.engineering.backend.entity;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.UUID;
@Table("bank_accounts")  // Spring Data Cassandra annotation
@Data
public class BankAccount {
    @PrimaryKey  // Simple partition key (UUID); no clustering key needed for this basic setup
    private UUID id;
    // Optional: Use @Column for explicit mapping, but not required for simple fields
    // @Column("account_number")
    private String accountNumber;
    // @Column("balance")
    private BigDecimal balance;
    // @Column("owner_name")
    private String ownerName;
}