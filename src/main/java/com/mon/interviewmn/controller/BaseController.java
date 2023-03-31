package com.mon.interviewmn.controller;

import com.mon.interviewmn.dto.BaseDTO;
import com.mon.interviewmn.service.BaseService;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public abstract class BaseController<Service extends BaseService<?, DTO, ?>, DTO extends BaseDTO> {
    @Autowired
    protected Service service;

    @GetMapping("")
    public ResponseEntity<List<DTO>> getAll(@RequestParam Map<String, String> param) throws ParseException {
        List<DTO> result = service.findAll(param);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("")
    public ResponseEntity<DTO> create(@Validated(BaseDTO.Create.class) @RequestBody DTO dto) {

        DTO result = service.create(dto);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/code")
    public ResponseEntity<DTO> update(@PathVariable Long code,
                                      @Validated(BaseDTO.Update.class) @RequestBody DTO dto) {
        DTO result = service.update(dto);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert("ApplicationName", false, "EntityName",
                result.getClass().toString())).body(result);
    }

    @GetMapping("/{code}")
    public ResponseEntity<DTO> getDetails(@PathVariable Long code) {
        Optional<DTO> categoryDTO = service.getDetails(code);
        return ResponseUtil.wrapOrNotFound(categoryDTO);
    }

}
