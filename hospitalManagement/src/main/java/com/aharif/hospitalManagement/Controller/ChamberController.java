package com.aharif.hospitalManagement.Controller;


import com.aharif.hospitalManagement.entity.Chamber;
import com.aharif.hospitalManagement.entity.User;
import com.aharif.hospitalManagement.repo.ChamberRepo;
import com.aharif.hospitalManagement.repo.RoleRepo;
import com.aharif.hospitalManagement.repo.UserRegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/chamber/")
public class ChamberController {



    @Autowired
    private ChamberRepo chamberRepo;




    @GetMapping(value = "add")
    public String addChamberView(Model model) {
        model.addAttribute("chamber", new Chamber());
        model.addAttribute("chamberlist",chamberRepo.findAll());
        return "chamber/add";
    }


    @PostMapping(value = "add")
    public String addChamber(@Valid Chamber chamber, BindingResult result, Model model){
        if(result.hasErrors()){
            return "chamber/add";
        }else {
            if (chamber != null){
                Chamber chamber1 = this.chamberRepo.findBydoctorName(chamber.getDoctorName());
                if (chamber1 != null){
                    model.addAttribute("existMsg", "Chamber is already exist");
                }else {
                    this.chamberRepo.save(chamber);
                    model.addAttribute("chamber", new Chamber());
                    model.addAttribute("chamberlist",chamberRepo.findAll());
                    model.addAttribute("successMsg", "Welcome!!! Data Added Successfully...");
                }
            }
        }
        return "chamber/add";
    }


    @GetMapping(value = "/list")
    public String chamberList(Model model) {
        model.addAttribute("list", this.chamberRepo.findAll());
        return "chamber/list";
    }



    @GetMapping(value = "/edit/{id}")
    public String editChamberView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("chamber", this.chamberRepo.getOne(id));
        return "chamber/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editChamber(@Valid Chamber chamber, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "chamber/edit";
        } else {
            if (chamber != null) {
                Chamber chamber1 = this.chamberRepo.findBydoctorName(Chamber.class.getName());
                if (chamber != null) {
                    model.addAttribute("existMsg", "Chamber is already exist");
                    return "chamber/edit";
                } else {
                    this.chamberRepo.save(chamber);
                    model.addAttribute("chamber", new Chamber());
                    model.addAttribute("successMsg", "Already Success");
                }
            }
        }
        return "redirect:/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delUser(@PathVariable("id") Long id) {
        this.chamberRepo.deleteById(id);
        return "redirect:/list";

    }






}
