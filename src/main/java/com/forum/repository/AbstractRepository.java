package com.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.forum.domain.AbstractEntity;

@NoRepositoryBean
public interface AbstractRepository <T extends AbstractEntity> extends JpaRepository<T, Long> {

}