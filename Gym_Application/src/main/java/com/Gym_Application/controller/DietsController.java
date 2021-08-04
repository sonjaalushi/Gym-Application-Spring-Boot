package com.Gym_Application.controller;

import com.Gym_Application.Service.CustomerService;
import com.Gym_Application.Service.DietsService;
import com.Gym_Application.entity.Customer;
import com.Gym_Application.entity.Diets;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/")
public class DietsController {

    private final DietsService dietsService;

    public DietsController( DietsService dietsService) {
        this.dietsService = dietsService;

    }

    @GetMapping("/getDiets")

    public List<Diets> getAllDiets(Diets diets) {
        return dietsService.getAllDiets();

    }


    @PostMapping("/saveDiets")

    public Diets saveDiets(@ModelAttribute("diets") Diets diets) {

        return dietsService.saveDiets(diets);

    }

    @GetMapping("/updateDiets/{id}")
    public Diets updateDiets(@PathVariable(value = "id") long id, Diets diets) {
        return dietsService.getDietsById(id);
        //  .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + id ));;
    }


    @DeleteMapping("/deleteDiets/{id}")
    public Diets deleteCustomer(@PathVariable(value = "id") long id, Diets diets) {
        return dietsService.deleteDietsById(id);
    }

}
