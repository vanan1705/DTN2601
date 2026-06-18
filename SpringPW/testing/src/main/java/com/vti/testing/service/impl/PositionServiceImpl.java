package com.vti.testing.service.impl;


import com.vti.testing.Repository.IPositionRepository;
import com.vti.testing.dto.PositionDTO;
import com.vti.testing.entity.Position;
import com.vti.testing.service.IPositionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PositionServiceImpl implements IPositionService {

    @Autowired
    private IPositionRepository positionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PositionDTO> findAll() {
        List<Position> positions =positionRepository.findAll();
        List<PositionDTO> positionDTOS = new ArrayList<>();
        for (Position position: positions){

            PositionDTO dto = modelMapper.map(position, PositionDTO.class);
            positionDTOS.add(dto);
        }
        return positionDTOS;
    }

    @Override
    public void create(Position position) {
        positionRepository.save(position);
    }
}
