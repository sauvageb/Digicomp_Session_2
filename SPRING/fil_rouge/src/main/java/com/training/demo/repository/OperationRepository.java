package com.training.demo.repository;

import com.training.demo.repository.entity.OperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OperationRepository extends JpaRepository<OperationEntity, UUID> {

    @Query("SELECT op FROM OperationEntity op ORDER BY op.createdAt DESC")
    List<OperationEntity> findAll();

    @Query("SELECT op FROM OperationEntity op WHERE CAST(op.id AS string) LIKE %:id%")
    List<OperationEntity> searchByIdLike(@Param("id") String id);
}
