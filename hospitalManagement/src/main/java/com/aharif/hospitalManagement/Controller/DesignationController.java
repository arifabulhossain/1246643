package com.aharif.hospitalManagement.Controller;


import com.aharif.hospitalManagement.entity.Designation;
import com.aharif.hospitalManagement.repo.DesignationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/designation/")
public class DesignationController {


    @Autowired
    private DesignationRepo repo;

    @GetMapping(value = "add")
    public String addDesignationView(Model model) {
        model.addAttribute("designation", new Designation());

        return "designation/add";
    }


    @PostMapping(value = "add")
    public String addDesignation(@Valid Designation designation, BindingResult result, Model model){
        if(result.hasErrors()){
            return "Designation/add";
        }else {
            if (designation != null){
                Designation designation1 = this.repo.findByDName(designation.getdName());
                if (designation1 != null){
                    model.addAttribute("existMsg", "DesignationName is already exist");
                }else {
                    this.repo.save(designation);
                    model.addAttribute("designation", new Designation());
                    model.addAttribute("successMsg", "Welcome!!! Data Added  Successfully...");
                }
            }
        }
        return "designation/add";
    }


    @GetMapping(value = "/list")
    public String designationtList(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "designation/list";
    }



    @GetMapping(value = "/edit/{id}")
    public String editDesignationView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("designation", this.repo.getOne(id));
        return "designation/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editdesignation(@Valid Designation designation, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "designation/edit";
        } else {
            if (designation != null) {
                Designation designation1 = this.repo.findByDName(designation.getdName());
                if (designation != null) {
                    model.addAttribute("existMsg", "DesignationName is already exist");
                    return "Designation/edit";
                } else {
                    this.repo.save(designation);
                    model.addAttribute("department", new Designation());
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
