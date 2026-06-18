package com.vti.testing.service;

import com.vti.testing.dto.PositionDTO;
import com.vti.testing.entity.Position;

import java.util.List;

public interface IPositionService {
    List<PositionDTO> findAll();

    void create(Position position);
}
