package com.aharif.hospitalManagement.Controller;


import com.aharif.hospitalManagement.entity.Ptest;
import com.aharif.hospitalManagement.repo.PtestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/ptest/")
public class PtestController {

    @Autowired
    private PtestRepo repo;

    @GetMapping(value = "add")
    public String addDrugView(Model model) {
        model.addAttribute("ptest", new Ptest());

        return "ptest/add";
    }


    @PostMapping(value = "add")
    public String adddrug(@Valid Ptest ptest, BindingResult result, Model model){

        if(result.hasErrors()){
            return "ptest/add";
        }else {
            if (ptest != null){
                Ptest ptest1 = this.repo.findBypName(ptest.getpName());
                if (ptest1 != null){
                    model.addAttribute("existMsg", "testName is already exist");
                }else {
                    this.repo.save(ptest);
                    model.addAttribute("ptest", new Ptest());
                    model.addAttribute("successMsg", "Welcome!!! Data Added Successfully...");
                }
            }
        }
        return "ptest/add";
    }


    @GetMapping(value = "/list")
    public String adviceList(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "ptest/list";
    }



    @GetMapping(value = "/edit/{id}")
    public String editAdvicetView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("drug", this.repo.getOne(id));
        return "drug/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editAdvice(@Valid Ptest ptest, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "ptest/edit";
        } else {
            if (ptest != null) {
                Ptest ptest1 = this.repo.findBypName(ptest.getpName());
                if (ptest1 != null) {
                    model.addAttribute("existMsg", "PattientName is already exist");
                    return "ptest/edit";
                } else {
                    this.repo.save(ptest);
                    model.addAttribute("ptest", new Ptest());
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
