package com.cpe.backend.review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;


import com.cpe.backend.employee.entity.Employee;
import com.cpe.backend.review.entity.SatisfactionLevel;
import com.cpe.backend.review.entity.ImprovementType;
import com.cpe.backend.review.entity.Review;


import com.cpe.backend.employee.repository.EmployeeRepository;
import com.cpe.backend.review.repository.SatisfactionLevelRepository;
import com.cpe.backend.review.repository.ImprovementTypeRepository;
import com.cpe.backend.review.repository.ReviewRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class ReviewController {
    @Autowired
    private final ReviewRepository reviewRepository;
    @Autowired
    private SatisfactionLevelRepository satisfactionLevelRepository;
    @Autowired
    private ImprovementTypeRepository improvementTypeRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    

    ReviewController(ReviewRepository reviewRepository,SatisfactionLevelRepository satisfactionLevelRepository,ImprovementTypeRepository improvementTypeRepository,EmployeeRepository employeeRepository) {
        this.reviewRepository = reviewRepository;
        this.satisfactionLevelRepository = satisfactionLevelRepository;
        this.improvementTypeRepository = improvementTypeRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/review")
    public Collection<Review> Reviews() {
        return reviewRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/review/{satisfaction_id}/{improvement_id}/{employee_id}/{comment}")
    public Review newReview(Review newReview,
    @PathVariable long satisfaction_id,
    @PathVariable long employee_id,
    @PathVariable long improvement_id,
    @PathVariable String comment ) {

    SatisfactionLevel reviewSatis = satisfactionLevelRepository.findById(satisfaction_id);
    ImprovementType reviewImprovementType = improvementTypeRepository.findById(improvement_id);
    Employee reviewEmployee = employeeRepository.findById(employee_id);
    

    newReview.setReviewSatis(reviewSatis);
    newReview.setReviewImprovementType(reviewImprovementType);
    newReview.setReviewEmployee(reviewEmployee);
    newReview.setReviewDate(new Date());
    newReview.setComment(comment);
    
    return reviewRepository.save(newReview); //บันทึก Objcet review
    
    }
}