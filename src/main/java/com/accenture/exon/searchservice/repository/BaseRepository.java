package com.accenture.exon.searchservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository  extends JpaRepository {

        <S> S save(S entity, Long userID);
        <S> S update(S entity, Long userID);
}
