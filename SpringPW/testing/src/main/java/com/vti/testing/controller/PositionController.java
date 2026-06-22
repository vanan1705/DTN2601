package com.vti.testing.controller;

import com.vti.testing.dto.PositionDTO;
import com.vti.testing.entity.Department;
import com.vti.testing.entity.Position;
import com.vti.testing.form.PositionSearchForm;
import com.vti.testing.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/positons")
public class PositionController {
    @Autowired
    private IPositionService positionService;

    @GetMapping
    public ResponseEntity<Page<PositionDTO>> findAll(Pageable pageable, PositionSearchForm form) {
        Page<PositionDTO> positionDTOS = positionService.findAll(pageable, form);
        return new ResponseEntity<>(positionDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Position> create (@RequestBody Position position) {
        positionService.create(position);
        return new ResponseEntity<>(position, HttpStatus.CREATED);
    }
}
