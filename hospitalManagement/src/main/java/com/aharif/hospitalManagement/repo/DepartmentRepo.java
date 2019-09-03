package com.aharif.hospitalManagement.repo;


import com.aharif.hospitalManagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {

    Department findByDepartmentName(String departmentName);
    boolean existsDepartmentBydepartmentName(String departmentName);


}
