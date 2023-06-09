package com.hyun.honey.domain.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberEntityRepository extends JpaRepository<MemberEntity, Long> {
}
