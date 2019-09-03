package com.aharif.hospitalManagement.Controller;



import com.aharif.hospitalManagement.entity.Chamber;
import com.aharif.hospitalManagement.entity.Doctor;
import com.aharif.hospitalManagement.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/doctor/")
public class DoctorController {

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private DesignationRepo designationRepo;


    @Autowired
    private ChamberRepo chamberRepo;

    @Autowired
    private UserRegistrationRepo userRepo;




    @GetMapping(value = "add")
    public String addUserView(Model model) {
        model.addAttribute("doctor", new Doctor());
        model.addAttribute("departmentlist", departmentRepo.findAll());
        model.addAttribute("designationlist", designationRepo.findAll());
        model.addAttribute("chamberlist", chamberRepo.findAll());
        model.addAttribute("userlist", userRepo.findAll());
        return "doctor/add";


    }


    @PostMapping(value = "add")
    public String addDoctor(@Valid Doctor doctor, BindingResult result, Model model){
        if(result.hasErrors()){
            return "doctor/add";
        }else {
            if (doctor != null){
                Doctor doctor1 = this.doctorRepo.findByDoctorName(doctor.getDoctorName());
                if (doctor1 != null){
                    model.addAttribute("existMsg", "DoctorName is already exist");
                }else {
                    this.doctorRepo.save(doctor);
                    model.addAttribute("doctor", new Doctor());
                    model.addAttribute("departmentlist",departmentRepo.findAll());
                    model.addAttribute("designationlist",designationRepo.findAll());
                    model.addAttribute("userlist",userRepo.findAll());

                    model.addAttribute("successMsg", "Welcome!!! Data Added Successfully...");
                }
            }
        }
        return "doctor/add";
    }


    @GetMapping(value = "/list")
    public String doctorList(Model model) {
        model.addAttribute("list", this.doctorRepo.findAll());
        return "doctor/list";
    }



    @GetMapping(value = "/edit/{id}")
    public String editDoctorView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("doctor", this.doctorRepo.getOne(id));
        return "doctor/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editDoctor(@Valid Doctor doctor, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "doctor/edit";
        } else {
            if (doctor != null) {
                Doctor doctor1 = this.doctorRepo.findByDoctorName(doctor.getDoctorName());
                if (doctor != null) {
                    model.addAttribute("existMsg", "DoctorName is already exist");
                    return "doctor/edit";
                } else {
                    this.doctorRepo.save(doctor);
                    model.addAttribute("doctor", new Doctor());
                    model.addAttribute("successMsg", "Welcome!!! Data Added Successfully...");
                }
            }
        }
        return "redirect:/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delDoctor(@PathVariable("id") Long id) {
        this.doctorRepo.deleteById(id);
        return "redirect:/list";

    }
    }
