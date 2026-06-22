package com.vti.testing.service.impl;


import com.vti.testing.Repository.IPositionRepository;
import com.vti.testing.dto.PositionDTO;
import com.vti.testing.entity.Position;
import com.vti.testing.form.PositionSearchForm;
import com.vti.testing.service.IPositionService;
import com.vti.testing.specification.PositionCustomSpecification;
import io.micrometer.common.util.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.domain.Specification;
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
    public Page<PositionDTO> findAll(Pageable pageable, PositionSearchForm form) {
        Specification<Position> where = Specification.unrestricted();

        if(StringUtils.isNotEmpty(form.getName())){
            PositionCustomSpecification name = new PositionCustomSpecification("name", form.getName());
            where = where.and(name);
        }

        Page<Position> positionPage = positionRepository.findAll(where, pageable);
        Page<PositionDTO> dtoPage = positionPage.map(position -> modelMapper.map(position, PositionDTO.class));
        return dtoPage;
    }

    @Override
    public void create(Position position) {
        positionRepository.save(position);
    }
}
