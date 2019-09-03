package com.aharif.hospitalManagement.Controller;


import com.aharif.hospitalManagement.entity.Test;
import com.aharif.hospitalManagement.repo.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping(value = "/test/")
public class TestController {



    @Autowired
    private TestRepo repo;

    @GetMapping(value = "add")
    public String addDrugView(Model model) {
        model.addAttribute("test", new Test());

        return "test/add";
    }


    @PostMapping(value = "add")
    public String adddrug(@Valid Test test, BindingResult result, Model model){
        //test.setTestDate(new Date());
        if(result.hasErrors()){
            return "test/add";
        }else {
            if (test != null){
                Test test1 = this.repo.findBytestName(test.getTestName());
                if (test1 != null){
                    model.addAttribute("existMsg", "testName is already exist");
                }else {
                    this.repo.save(test);
                    model.addAttribute("test", new Test());
                    model.addAttribute("successMsg", "Welcome!!! Data Added Successfully...");
                }
            }
        }
        return "test/add";
    }


    @GetMapping(value = "/list")
    public String adviceList(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "test/list";
    }



    @GetMapping(value = "/edit/{id}")
    public String editAdvicetView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("drug", this.repo.getOne(id));
        return "drug/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editAdvice(@Valid Test test, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "test/edit";
        } else {
            if (test != null) {
                Test test1 = this.repo.findBytestName(test.getTestName());
                if (test1 != null) {
                    model.addAttribute("existMsg", "PattientName is already exist");
                    return "drug/edit";
                } else {
                    this.repo.save(test);
                    model.addAttribute("test", new Test());
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
