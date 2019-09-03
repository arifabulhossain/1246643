package com.aharif.hospitalManagement.Controller;


import com.aharif.hospitalManagement.entity.Advice;
import com.aharif.hospitalManagement.repo.AdviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/advice/")
public class AdviceController {


    @Autowired
    private AdviceRepo repo;

    @GetMapping(value = "add")
    public String addAdviceView(Model model) {
        model.addAttribute("advice", new Advice());

        return "advice/add";
    }


    @PostMapping(value = "add")
    public String adddvice(@Valid Advice advice, BindingResult result, Model model){
        if(result.hasErrors()){
            return "advice/add";
        }else {
            if (advice != null){
                Advice advice1 = this.repo.findByPatientName(advice.getPatientName());
                if (advice1 != null){
                    model.addAttribute("existMsg", "PatientName is already exist");
                }else {
                    this.repo.save(advice);
                    model.addAttribute("advice", new Advice());
                    model.addAttribute("successMsg", "Already Success");
                }
            }
        }
        return "advice/add";
    }


    @GetMapping(value = "/list")
    public String adviceList(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "advice/list";
    }



    @GetMapping(value = "/edit/{id}")
    public String editAdvicetView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("advice", this.repo.getOne(id));
        return "advice/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editAdvice(@Valid Advice advice, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "advice/edit";
        } else {
            if (advice != null) {
                Advice advice1 = this.repo.findByPatientName(advice.getPatientName());
                if (advice1 != null) {
                    model.addAttribute("existMsg", "PattientName is already exist");
                    return "advice/edit";
                } else {
                    this.repo.save(advice);
                    model.addAttribute("department", new Advice());
                    model.addAttribute("successMsg", "Welcome!!! Data Added Successfully...");
                }
            }
        }
        return "redirect:/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delAdvice(@PathVariable("id") Long id) {
        this.repo.deleteById(id);
        return "redirect:/list";

    }

}
