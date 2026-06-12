package com.vti.testing.controller;


import com.vti.testing.entity.Account;
import com.vti.testing.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @GetMapping
    public ResponseEntity<List<Account>> findAll() {
        List<Account> accounts = accountService.findAll();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Account> findById(@PathVariable(name = "id") Integer id) {
        Account account = accountService.findById(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Account> findByUserName(@PathVariable(name = "userName") String userName) {
        Account account = accountService.findByUserName(userName);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Account> create (@RequestBody Account account) {
        accountService.create(account);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Account> update (@PathVariable(name = "id") Integer id, @RequestBody Account account) {
        accountService.update(id, account);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

}
