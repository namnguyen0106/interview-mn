package com.mon.interviewmn.service;

import com.mon.interviewmn.dto.BaseDTO;
import com.mon.interviewmn.model.BaseEntity;
import com.mon.interviewmn.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Transactional
public abstract class BaseService<Repository extends BaseRepository<Entity> & JpaRepository<Entity, ?>, DTO extends BaseDTO, Entity extends BaseEntity> {

    public abstract DTO create(DTO dto);

    public abstract DTO update(DTO dto);

    public abstract Optional<DTO> getDetails(Long id);

    public abstract DTO delete(DTO dto);

    public abstract List<DTO> findAll(Map<String, String> param) throws ParseException;

}
