package com.vti.testing.controller;


import com.vti.testing.dto.AccountDTO;
import com.vti.testing.entity.Account;
import com.vti.testing.form.AccountCreateForm;
import com.vti.testing.form.AccountSearchForm;
import com.vti.testing.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<Page<AccountDTO>> findAll(Pageable  pageable, AccountSearchForm form) {
        Page<AccountDTO> accountDTOS = accountService.findAll(pageable, form);
        return new ResponseEntity<>(accountDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AccountDTO> findById(@PathVariable(name = "id") Integer id) {
        AccountDTO accountDTO = accountService.findById(id);
        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<AccountDTO> findByUserName(@PathVariable(name = "userName") String userName) {
        AccountDTO accountDTO = accountService.findByUserName(userName);
        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create (@RequestBody AccountCreateForm accountCreateForm) {
        accountService.create(accountCreateForm);
        return new ResponseEntity<>("Create successfully", HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update (@PathVariable(name = "id") Integer id, @RequestBody AccountCreateForm accountCreateForm) {
        accountService.update(id, accountCreateForm);
        return new ResponseEntity<>("Update successfully", HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") Integer id) {
        accountService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
