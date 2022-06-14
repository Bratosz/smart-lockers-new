package pl.bratosz.smartlockers.controller;

import org.springframework.web.bind.annotation.*;
import pl.bratosz.smartlockers.service.pasting.PastingEmployeeService;
import pl.bratosz.smartlockers.service.pasting.employee.PastedEmployeeEDPL;

import java.util.List;

@RestController
@RequestMapping("/paste")
public class PastingEmployeeController {

    private PastingEmployeeService pastingEmployeeService;

    public PastingEmployeeController(PastingEmployeeService pastingEmployeeService) {
        this.pastingEmployeeService = pastingEmployeeService;
    }

    @PostMapping("/add-employees-edpl/{userId}")
    public void addEmployeesEDPL(@PathVariable long userId, @RequestBody List<PastedEmployeeEDPL> employees) {
        pastingEmployeeService.add(userId, employees);
    }
}
