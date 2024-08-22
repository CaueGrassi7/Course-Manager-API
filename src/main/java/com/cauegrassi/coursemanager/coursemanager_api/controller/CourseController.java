package com.cauegrassi.coursemanager.coursemanager_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cauegrassi.coursemanager.coursemanager_api.model.Course;
import com.cauegrassi.coursemanager.coursemanager_api.repository.CourseRepository;

@RestController
@RequestMapping("/courses")
public class CourseController {
    
    @Autowired
    private CourseRepository courseRepository;

    // Get all courses
    @GetMapping
    public List<Course> getAllCourses() {

        return courseRepository.findAll();
    }

    // Get a specific couse by ID
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {

        Optional<Course> course = courseRepository.findById(id);
        if(course.isPresent()) {
            return ResponseEntity.ok(course.get());
        } 

        return ResponseEntity.notFound().build();
    }

    // Create a new course
    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    // Update an existing course
    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course courseDetails) {

        Optional<Course> courseOptional = courseRepository.findById(id);

        if(courseOptional.isPresent()) {
            Course course = courseOptional.get();
            course.setName(courseDetails.getName());
            course.setCategory(courseDetails.getCategory());
            course.setActive(courseDetails.isActive());
            course.setUpdatedAt(courseDetails.getUpdatedAt());

            Course updatedCourse = courseRepository.save(course);
            return ResponseEntity.ok(updatedCourse);
        }

        return ResponseEntity.notFound().build();
    }

    // Delete a course
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id){
        Optional<Course> course = courseRepository.findById(id);

        if(course.isPresent()) {
            courseRepository.delete(course.get());
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
