package com.training.demo.controller;

import ch.qos.logback.core.util.StringUtil;
import com.training.demo.csv.CsvService;
import com.training.demo.csv.OperationCSVRepresentation;
import com.training.demo.dto.CreateOperation;
import com.training.demo.dto.OperationDirectionChecked;
import com.training.demo.model.Operation;
import com.training.demo.model.OperationDirection;
import com.training.demo.service.OperationService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping(value = "/operations")
public class OperationController {

    @Autowired
    private CsvService<Operation, OperationCSVRepresentation> csvService;

    @Autowired
    private OperationService operationService;

    @GetMapping("/export")
    public void exportCSV(HttpServletResponse response) throws IOException {
        List<Operation> operationList = operationService.getOperations();
        response.setContentType("text/csv");
        response.addHeader("Content-Disposition", "attachment; filename=\"export.csv\"");
        // csvService.parseCSV(null, OperationCSVRepresentation.class);
    }


    @GetMapping()
    public String fetchAll(Model model,
                           @RequestParam(value = "searchId", required = false) String searchId) {
        List<Operation> operationList;
        if (StringUtil.isNullOrEmpty(searchId)) {
            operationList = operationService.getOperations();
        } else {
            operationList = operationService.searchOperations(searchId);
        }
        model.addAttribute("searchId", searchId);
        model.addAttribute("operations", operationList);


        List<OperationDirectionChecked> directions = Arrays
                .stream(OperationDirection.values())
                .map(x -> new OperationDirectionChecked(x, true))
                .toList();

        model.addAttribute("directions", directions);


        return "operations/operation_list.html";
    }

    @GetMapping("/create")
    public String displayCreateForm(Model model) {
        model.addAttribute("newOperation", new CreateOperation());
        return "operations/operation_create.html";
    }

    @PostMapping("/create")
    public RedirectView createForm(CreateOperation operation) {
        operationService.createOperation(operation.getAmount(), operation.getDirection());
        return new RedirectView("/operations");
    }

    @GetMapping("/{id}")
    public String displayDetailsOperation(@PathVariable("id") UUID id, Model model) {
        Optional<Operation> opOptional = operationService.getOperationById(id);

        if (opOptional.isPresent()) {
            Operation operationFound = opOptional.get();
            model.addAttribute("operation", operationFound);
        }
        return "operations/operation_details.html";
    }

    @PostMapping("/delete")
    public RedirectView delete(@RequestParam("id") UUID id) {
        operationService.delete(id);
        return new RedirectView("/operations");
    }

    @PostMapping("/delete/all")
    public RedirectView deleteAll() {
        operationService.deleteAll();
        return new RedirectView("/operations");
    }

}

