package com.aharif.hospitalManagement.Controller;


import com.aharif.hospitalManagement.entity.PaymentInfo;
import com.aharif.hospitalManagement.repo.DoctorRepo;
import com.aharif.hospitalManagement.repo.PatientRepo;
import com.aharif.hospitalManagement.repo.PaymentInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Date;


@Controller
@RequestMapping(value = "/paymentinfo/")
public class PaymentInfoController {
    @Autowired
    private PaymentInfoRepo paymentInfoRepo;

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private PatientRepo patientRepo;

/////////////////////////////////////////////////////////////////


    @GetMapping(value = "add")
    public String addPaymentInfoView(Model model) {

        model.addAttribute("paymentinfo", new PaymentInfo());

        model.addAttribute("doctorlist", doctorRepo.findAll());

        model.addAttribute("patientlist", patientRepo.findAll());
        return "paymentinfo/add";


    }


    @PostMapping(value = "add")
    public String addAttendant(@Valid PaymentInfo paymentinfo, BindingResult result, Model model){
        paymentinfo.setPaymentDate(new Date());
        if(result.hasErrors()){
            return "paymentinfo/add";
        }else {
                    this.paymentInfoRepo.save(paymentinfo);
                    model.addAttribute("paymentinfo", new PaymentInfo());
                    model.addAttribute("doctorlist",doctorRepo.findAll());

                    model.addAttribute("patientlist",patientRepo.findAll());

                    model.addAttribute("successMsg", "Welcome!!! Data Added Successfully...");
        }
        return "paymentinfo/add";
    }

    double totalAmount =0.0;

    @GetMapping(value = "/list")
    public String doctorList(Model model) {
        model.addAttribute("list", this.paymentInfoRepo.findAll());
        totalAmount =0.0;
        this.paymentInfoRepo.findAll().forEach((paymentInfo)->{
            totalAmount += paymentInfo.getFeeAmount();
        });

        model.addAttribute("totalAmount", totalAmount);
        return "paymentinfo/list";
    }
    @GetMapping(value = "/todaycollection")
    public String todayTotalCollectionByDate(Model model) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate= formatter.format(new Date());
        Date date = null;
        try {
             date = formatter.parse(strDate);
        }catch (ParseException de){
            de.printStackTrace();
        }


        model.addAttribute("list", this.paymentInfoRepo.findAllByPaymentDate(date));
        totalAmount =0.0;
        this.paymentInfoRepo.findAllByPaymentDate(date).forEach((paymentInfo)->{
            totalAmount += paymentInfo.getFeeAmount();
        });

        model.addAttribute("totalAmount", totalAmount);
        return "paymentinfo/todaycollection";
    }


    @GetMapping(value = "/edit/{id}")
    public String editDoctorView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("paymentinfo", this.paymentInfoRepo.getOne(id));
        return "paymentinfo/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editDoctor(@Valid PaymentInfo paymentInfo, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "paymentinfo/edit";
        } else {
            if (paymentInfo != null) {
//                PaymentInfo paymentInfo1 = this.paymentInfoRepo.findByPaymentDate(paymentInfo.getPaymentDate(new Date()));
//                if (paymentInfo != null) {
//                    model.addAttribute("existMsg", "DoctorName is already exist");
//                    return "paymentinfo/edit";
//                } else {
//                    this.paymentInfoRepo.save(paymentInfo);
//                    model.addAttribute("attendant", new PaymentInfo());
//                    model.addAttribute("successMsg", "Alread Success");
//                }
            }
        }
        return "redirect:/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delAttendant(@PathVariable("id") Long id) {
        this.paymentInfoRepo.deleteById(id);
        return "redirect:/list";

    }



}
