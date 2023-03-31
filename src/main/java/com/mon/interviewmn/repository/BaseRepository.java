package com.mon.interviewmn.repository;

import com.mon.interviewmn.model.BaseEntity;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> {

}
