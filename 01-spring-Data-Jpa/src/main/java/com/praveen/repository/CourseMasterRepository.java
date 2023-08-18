package com.praveen.repository;

import com.praveen.entity.CourseMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMasterRepository extends JpaRepository<CourseMaster ,Long> {
}
