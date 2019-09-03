package com.aharif.hospitalManagement.Controller;


import com.aharif.hospitalManagement.entity.Causees;

import com.aharif.hospitalManagement.repo.CauseesRepo;
import com.aharif.hospitalManagement.repo.DrugRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/causees/")
public class CausesController {
    @Autowired
    private CauseesRepo repo;

    @GetMapping(value = "add")
    public String addCausesView(Model model) {
        model.addAttribute("causees", new Causees());

        return "causees/add";
    }


    @PostMapping(value = "add")
    public String adddrug(@Valid Causees causees, BindingResult result, Model model){
        if(result.hasErrors()){
            return "causees/add";
        }else {
            if (causees != null){
                Causees causees1 = this.repo.findBydiseaseName(causees.getDiseaseName());
                if (causees1 != null){
                    model.addAttribute("existMsg", "drugName is already exist");
                }else {
                    this.repo.save(causees);
                    model.addAttribute("causees", new Causees());
                    model.addAttribute("successMsg", "Welcome!!! Data Added Successfully...");
                }
            }
        }
        return "causees/add";
    }


    @GetMapping(value = "/list")
    public String adviceList(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "causees/list";
    }



    @GetMapping(value = "/edit/{id}")
    public String editAdvicetView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("causees", this.repo.getOne(id));
        return "causees/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editAdvice(@Valid Causees causees, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "causees/edit";
        } else {
            if (causees != null) {
                Causees causees1 = this.repo.findBydiseaseName(causees.getDiseaseName());
                if (causees1 != null) {
                    model.addAttribute("existMsg", "CauseesName is already exist");
                    return "drug/edit";
                } else {
                    this.repo.save(causees);
                    model.addAttribute("causees", new Causees());
                    model.addAttribute("successMsg", "Already Success");
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
