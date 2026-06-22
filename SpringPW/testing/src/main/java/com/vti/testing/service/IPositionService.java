package com.vti.testing.service;

import com.vti.testing.dto.PositionDTO;
import com.vti.testing.entity.Position;
import com.vti.testing.form.PositionSearchForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPositionService {
    Page<PositionDTO> findAll(Pageable pageable, PositionSearchForm form);

    void create(Position position);
}
