package com.aharif.hospitalManagement.Controller;


import com.aharif.hospitalManagement.entity.Doctor;
import com.aharif.hospitalManagement.entity.Serial;
import com.aharif.hospitalManagement.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping(value = "/serial/")
public class SerialController {

    @Autowired
    private SerialRepo serialRepo;

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private ChamberRepo chamberRepo;

    ///////////////////////////////////////////////////////



    @GetMapping(value = "add")
    public String addUserView(Model model) {
        model.addAttribute("serial", new Serial());
        model.addAttribute("patienttlist", patientRepo.findAll());
        model.addAttribute("doctorlist", doctorRepo.findAll());
        model.addAttribute("chamberlist", chamberRepo.findAll());

        return "serial/add";


    }


    @PostMapping(value = "add")
    public String addDoctor(@Valid Serial serial, BindingResult result, Model model){
        serial.setAppoinmentDate(new Date());
        if(result.hasErrors()){
            return "serial/add";
        }else {
                Serial serial1 = this.serialRepo.findBySerialNo(serial.getSerialNo());
                if (serial1 != null){
                    model.addAttribute("existMsg", "DoctorName is already exist");
                }else {
                    this.serialRepo.save(serial);
                    model.addAttribute("serial", new Serial());
                    model.addAttribute("patientlist",patientRepo.findAll());
                    model.addAttribute("doctorlist",doctorRepo.findAll());
                    model.addAttribute("chamberlist",chamberRepo.findAll());

                    model.addAttribute("successMsg", "Welcome!!! Data Added Successfully...");
                }

        }
        return "serial/add";
    }


    @GetMapping(value = "/list")
    public String doctorList(Model model) {
        model.addAttribute("list", this.serialRepo.findAll());
        return "serial/list";
    }



    @GetMapping(value = "/edit/{id}")
    public String editDoctorView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("serial", this.serialRepo.getOne(id));
        return "serial/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editDoctor(@Valid Serial serial, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "serial/edit";
        } else {
            if (serial != null) {
                Serial serial1 = this.serialRepo.findBySerialNo(serial.getSerialNo());
                if (serial != null) {
                    model.addAttribute("existMsg", "DoctorName is already exist");
                    return "serial/edit";
                } else {
                    this.serialRepo.save(serial);
                    model.addAttribute("serial", new Serial());
                    model.addAttribute("successMsg", "Alread Success");
                }
            }
        }
        return "redirect:/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delDoctor(@PathVariable("id") Long id) {
        this.serialRepo.deleteById(id);
        return "redirect:/list";

    }

}
