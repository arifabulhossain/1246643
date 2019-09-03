package com.aharif.hospitalManagement.Controller;




import com.aharif.hospitalManagement.entity.Attendant;

import com.aharif.hospitalManagement.repo.AttendantRepo;
import com.aharif.hospitalManagement.repo.DoctorRepo;
import com.aharif.hospitalManagement.repo.UserRegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping(value = "/attendant/")
public class AttendantController {

    @Autowired
    private AttendantRepo attendantRepo;

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private UserRegistrationRepo userRepo;






    @GetMapping(value = "add")
    public String addAttendantView(Model model) {
        model.addAttribute("attendant", new Attendant());

        model.addAttribute("doctorlist", doctorRepo.findAll());

        model.addAttribute("userlist", userRepo.findAll());
        return "attendant/add";


    }


    @PostMapping(value = "add")
    public String addAttendant(@Valid Attendant attendant, BindingResult result, Model model){
        if(result.hasErrors()){
            return "attendant/add";
        }else {
            if (attendant != null){
                Attendant attendant1 = this.attendantRepo.findByAttendantName(attendant.getAttendantName());
                if (attendant1 != null){
                    model.addAttribute("existMsg", "DoctorName is already exist");
                }else {
                    this.attendantRepo.save(attendant);
                    model.addAttribute("attendant", new Attendant());
                    model.addAttribute("doctorlist",doctorRepo.findAll());

                    model.addAttribute("userlist",userRepo.findAll());

                    model.addAttribute("successMsg", "Welcome!!! Data Added Successfully...");
                }
            }
        }
        return "attendant/add";
    }


    @GetMapping(value = "/list")
    public String doctorList(Model model) {
        model.addAttribute("list", this.attendantRepo.findAll());
        return "attendant/list";
    }



    @GetMapping(value = "/edit/{id}")
    public String editDoctorView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("attendant", this.attendantRepo.getOne(id));
        return "attendant/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editDoctor(@Valid Attendant attendant, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "attendant/edit";
        } else {
            if (attendant != null) {
                Attendant attendant1 = this.attendantRepo.findByAttendantName(attendant.getAttendantName());
                if (attendant != null) {
                    model.addAttribute("existMsg", "DoctorName is already exist");
                    return "attendant/edit";
                } else {
                    this.attendantRepo.save(attendant);
                    model.addAttribute("attendant", new Attendant());
                    model.addAttribute("successMsg", "Alread Success");
                }
            }
        }
        return "redirect:/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delAttendant(@PathVariable("id") Long id) {
        this.attendantRepo.deleteById(id);
        return "redirect:/list";

    }


}
