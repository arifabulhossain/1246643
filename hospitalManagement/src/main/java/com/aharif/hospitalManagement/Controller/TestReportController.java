package com.aharif.hospitalManagement.Controller;


import com.aharif.hospitalManagement.entity.TestReport;
import com.aharif.hospitalManagement.repo.TestRepo;
import com.aharif.hospitalManagement.repo.TestReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping(value = "/testreport/")

public class TestReportController {


    @Autowired
    private TestReportRepo testReportRepo;

    @Autowired
    private TestRepo testRepo;

//////////////////////////////////////////////////


    @GetMapping(value = "add")
    public String addUserView(Model model) {
        model.addAttribute("testreport", new TestReport());
        model.addAttribute("testlist", testRepo.findAll());

        return "testreport/add";


    }


    @PostMapping(value = "add")
    public String addDoctor(@Valid TestReport testReport, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "testreport/add";
        } else {
            if (testReport != null) {
                TestReport testReport1 = this.testReportRepo.findByTestSample(testReport.getTestSample());
                if (testReport1 != null) {
                    model.addAttribute("existMsg", "SampleName is already exist");
                } else {
                    this.testReportRepo.save(testReport);
                    model.addAttribute("testreport", new TestReport());
                    model.addAttribute("testlist", testRepo.findAll());


                    model.addAttribute("successMsg", "Already Success");
                }
            }
        }
        return "testreport/add";
    }


    @GetMapping(value = "/list")
    public String doctorList(Model model) {
        model.addAttribute("list", this.testReportRepo.findAll());
        return "testreport/list";
    }


    @GetMapping(value = "/edit/{id}")
    public String editDoctorView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("testreport", this.testReportRepo.getOne(id));
        return "testreport/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editDoctor(@Valid TestReport testReport, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "testreport/edit";
        } else {
            if (testReport != null) {
                TestReport testReport1 = this.testReportRepo.findByTestSample(testReport.getTestSample());
                if (testReport != null) {
                    model.addAttribute("existMsg", "DoctorName is already exist");
                    return "testreport/edit";
                } else {
                    this.testReportRepo.save(testReport);
                    model.addAttribute("testreport", new TestReport());
                    model.addAttribute("successMsg", "Welcome!!! Data Added Successfully...");
                }
            }
        }
        return "redirect:/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delDoctor(@PathVariable("id") Long id) {
        this.testReportRepo.deleteById(id);
        return "redirect:/list";

    }


}
