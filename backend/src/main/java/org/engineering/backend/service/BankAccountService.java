package org.engineering.backend.service;

import org.engineering.backend.entity.BankAccount;
import org.engineering.backend.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class BankAccountService {
    @Autowired
    private BankAccountRepository repository;
    public List<BankAccount> getAllAccounts() {
        return repository.findAll();
    }
    public Optional<BankAccount> getAccountById(UUID id) {
        return repository.findById(id);
    }
    public BankAccount createAccount(BankAccount account) {
        account.setId(UUID.randomUUID());
        return repository.save(account);
    }
    public BankAccount updateAccount(UUID id, BankAccount accountDetails) {
        return repository.findById(id)
                .map(account -> {
                    account.setAccountNumber(accountDetails.getAccountNumber());
                    account.setBalance(accountDetails.getBalance());
                    account.setOwnerName(accountDetails.getOwnerName());
                    return repository.save(account);
                })
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }
    public void deleteAccount(UUID id) {
        repository.deleteById(id);
    }
}
