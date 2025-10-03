package org.engineering.backend.controller;

import org.engineering.backend.entity.BankAccount;
import org.engineering.backend.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/accounts")
@CrossOrigin(origins = "http://localhost:4200")  // Allow Angular frontend
public class BankAccountController {
    @Autowired
    private BankAccountService service;
    @GetMapping
    public List<BankAccount> getAllAccounts() {
        return service.getAllAccounts();
    }
    @GetMapping("/{id}")
    public ResponseEntity<BankAccount> getAccountById(@PathVariable UUID id) {
        return service.getAccountById(id)
                .map(account -> ResponseEntity.ok().body(account))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public BankAccount createAccount(@RequestBody BankAccount account) {
        return service.createAccount(account);
    }
    @PutMapping("/{id}")
    public ResponseEntity<BankAccount> updateAccount(@PathVariable UUID id, @RequestBody BankAccount account) {
        return ResponseEntity.ok(service.updateAccount(id, account));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable UUID id) {
        service.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }
}
