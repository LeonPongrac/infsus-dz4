package hr.infsus.controller;

import hr.infsus.dto.BoothApplicationInput;
import hr.infsus.model.BoothApplication;
import hr.infsus.service.BoothApplicationService;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class BoothApplicationController {
    @Autowired
    private BoothApplicationService service;

    @Autowired
    private RuntimeService runtimeService;

    @GetMapping("/boothApplicationForm")
    public String getBoothApplicationForm(Model model) {
        model.addAttribute("boothApplicationInput", new BoothApplicationInput());
        return "form";
    }

    @PostMapping("/api/boothApplications")
    public String createBoothApplication(@ModelAttribute BoothApplicationInput input) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("name", input.getName());
        variables.put("email", input.getEmail());
        variables.put("phone", input.getPhone());
        variables.put("boothNumber", input.getBoothNumber());
        variables.put("boothName", input.getBoothName());
        variables.put("boothDetails", input.getBoothDetails());
        runtimeService.startProcessInstanceByMessage("newForm", variables);
        return "processStarted";
    }
}
