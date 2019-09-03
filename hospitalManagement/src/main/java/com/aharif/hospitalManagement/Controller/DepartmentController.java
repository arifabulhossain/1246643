package com.aharif.hospitalManagement.Controller;


import com.aharif.hospitalManagement.entity.Department;
import com.aharif.hospitalManagement.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/department/")
public class DepartmentController {



    @Autowired
    private DepartmentRepo repo;

    @GetMapping(value = "add")
    public String addDepartmentView(Model model) {
        model.addAttribute("department", new Department());

        return "department/add";
    }


    @PostMapping(value = "add")
    public String addDepartment(@Valid Department department, BindingResult result, Model model){
        if(result.hasErrors()){
            return "department/add";
        }else {
            if (department != null){
                Department department1 = this.repo.findByDepartmentName(department.getDepartmentName());
                if (department1 != null){
                    model.addAttribute("existMsg", "DepartmentName is already exist");
                }else {
                    this.repo.save(department);
                    model.addAttribute("department", new Department());
                    model.addAttribute("successMsg", "Welcome!!! Data Added Succesfully...");
                }
            }
        }
        return "department/add";
    }


    @GetMapping(value = "/list")
    public String departmentList(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "department/list";
    }



    @GetMapping(value = "/edit/{id}")
    public String editDepartmentView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("department", this.repo.getOne(id));
        return "department/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editdepartment(@Valid Department department, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "department/edit";
        } else {
            if (department != null) {
                Department department1 = this.repo.findByDepartmentName(department.getDepartmentName());
                if (department1 != null) {
                    model.addAttribute("existMsg", "DepartmentName is already exist");
                    return "department/edit";
                } else {
                    this.repo.save(department);
                    model.addAttribute("department", new Department());
                    model.addAttribute("successMsg", "Already Success");
                }
            }
        }
        return "redirect:/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delDepartment(@PathVariable("id") Long id) {
        this.repo.deleteById(id);
        return "redirect:/list";

    }


}
