package com.aharif.hospitalManagement.Controller;



import com.aharif.hospitalManagement.entity.Drug;
import com.aharif.hospitalManagement.repo.DrugRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/drug/")
public class DrugController {


    @Autowired
    private DrugRepo repo;

    @GetMapping(value = "add")
    public String addDrugView(Model model) {
        model.addAttribute("drug", new Drug());

        return "drug/add";
    }


    @PostMapping(value = "add")
    public String adddrug(@Valid Drug drug, BindingResult result, Model model){
        if(result.hasErrors()){
            return "drug/add";
        }else {
            if (drug != null){
                Drug drug1 = this.repo.findBymName(drug.getmName());
                if (drug1 != null){
                    model.addAttribute("existMsg", "drugName is already exist");
                }else {
                    this.repo.save(drug);
                    model.addAttribute("drug", new Drug());
                    model.addAttribute("successMsg", "Already Success");
                }
            }
        }
        return "drug/add";
    }


    @GetMapping(value = "/list")
    public String adviceList(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "drug/list";
    }



    @GetMapping(value = "/edit/{id}")
    public String editAdvicetView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("drug", this.repo.getOne(id));
        return "drug/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editAdvice(@Valid Drug drug, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "drug/edit";
        } else {
            if (drug != null) {
               Drug drug1 = this.repo.findBymName(drug.getmName());
                if (drug1 != null) {
                    model.addAttribute("existMsg", "PattientName is already exist");
                    return "drug/edit";
                } else {
                    this.repo.save(drug);
                    model.addAttribute("drug", new Drug());
                    model.addAttribute("successMsg", "Welcome!!! Data Added  Successfully...");
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
