package com.cauegrassi.coursemanager.coursemanager_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cauegrassi.coursemanager.coursemanager_api.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
    
}
