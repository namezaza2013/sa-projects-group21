package com.cpe.backend.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

import com.cpe.backend.employee.entity.Employee;
import com.cpe.backend.employee.entity.Experience;
import com.cpe.backend.employee.entity.Responsibility;
import com.cpe.backend.employee.entity.WorkType;


import com.cpe.backend.employee.repository.EmployeeRepository;
import com.cpe.backend.employee.repository.ExperienceRepository;
import com.cpe.backend.employee.repository.ResponsibilityRepository;
import com.cpe.backend.employee.repository.WorkTypeRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class EmployeeController {
    @Autowired
    private final EmployeeRepository employeeRepository;
    @Autowired
    private ExperienceRepository  experienceRepository;
    @Autowired
    private ResponsibilityRepository responsibilityRepository;
    @Autowired
    private WorkTypeRepository worktypeRepository;

    public EmployeeController(EmployeeRepository employeeRepository, ExperienceRepository  experienceRepository,
    ResponsibilityRepository responsibilityRepository, WorkTypeRepository worktypeRepository) {
    this.employeeRepository = employeeRepository;
    this.experienceRepository = experienceRepository;
    this.responsibilityRepository = responsibilityRepository;
    this.worktypeRepository = worktypeRepository;
}

    
    @GetMapping("/employee")
    public Collection<Employee> Employees() {
        return employeeRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/employee/{name}/{address}/{nickname}/{experience_id}/{responsibility_id}/{worktype_id}")
    public Employee newEmployee(Employee newEmployee,
    @PathVariable String name,
    @PathVariable String address,
    @PathVariable String nickname,
   
    @PathVariable long experience_id,
    @PathVariable long responsibility_id,
    @PathVariable long worktype_id) {
                        
    Experience addexperience = experienceRepository.findById(experience_id);                    
    Responsibility addresponsibility = responsibilityRepository.findById(responsibility_id);                                
    WorkType addworktype = worktypeRepository.findById(worktype_id);                               

    newEmployee.setName(name);
    newEmployee.setAddress(address);
    newEmployee.setNickname(nickname);

    newEmployee.setAddexperience(addexperience);
    newEmployee.setAddresponsibility (addresponsibility);
    newEmployee.setAddworktype(addworktype);

    return employeeRepository.save(newEmployee); 

    
    
    }
}