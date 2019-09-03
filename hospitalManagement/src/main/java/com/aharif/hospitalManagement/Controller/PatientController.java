package com.aharif.hospitalManagement.Controller;


import com.aharif.hospitalManagement.entity.Patient;
//import com.aharif.hospitalManagement.entity.User;
import com.aharif.hospitalManagement.repo.PatientRepo;
//import com.aharif.hospitalManagement.repo.RoleRepo;
//import com.aharif.hospitalManagement.repo.UserRegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping(value = "/patient/")
public class PatientController {

    @Autowired
    private PatientRepo patientRepo;




    @GetMapping(value = "add")
    public String addPatientView(Model model) {
        model.addAttribute("patient", new Patient());
        model.addAttribute("patientlist",patientRepo.findAll());
        return "patient/add";
    }


    @PostMapping(value = "add")
    public String addPatient(@Valid Patient patient, BindingResult result, Model model){
        if(result.hasErrors()){
            return "patient/add";
        }else {
            if (patient != null){
                Patient patient1 = this.patientRepo.findByName(patient.getName());
                //Patient patient1 = this.patientRepo.findByPatientName(patient.getName());
                if (patient1 != null){
                    model.addAttribute("existMsg", "PatientName is already exist");
                }else {
                    patient.setAdmitDate(new Date());
                    this.patientRepo.save(patient);
                    model.addAttribute("patient", new Patient());
                    model.addAttribute("patientlist",patientRepo.findAll());
                    model.addAttribute("successMsg", "Welcome!!! Data Added Successfully...");
                }
            }
        }
        return "patient/add";
    }


    @GetMapping(value = "/list")
    public String patientList(Model model) {
        model.addAttribute("list", this.patientRepo.findAll());
        return "patient/list";
    }



    @GetMapping(value = "/edit/{id}")
    public String editUserView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("patient", this.patientRepo.getOne(id));
        return "patient/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editUser(@Valid Patient patient, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "patient/edit";
        } else {
            if (patient != null) {
                Patient patient1 = this.patientRepo.findByName(patient.getName());
                if (patient != null) {
                    model.addAttribute("existMsg", "PantientName is already exist");
                    return "patient/edit";
                } else {
                    this.patientRepo.save(patient);
                    model.addAttribute("patient", new Patient());
                    model.addAttribute("successMsg", "Alread Success");
                }
            }
        }
        return "redirect:/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delUser(@PathVariable("id") Long id) {
        this.patientRepo.deleteById(id);
        return "redirect:/list";

    }

}
