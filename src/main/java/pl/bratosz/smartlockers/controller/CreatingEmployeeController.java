package pl.bratosz.smartlockers.controller;

import org.springframework.web.bind.annotation.*;
import pl.bratosz.smartlockers.response.StandardResponse;
import pl.bratosz.smartlockers.service.pasting.CreatingEmployeeService;
import pl.bratosz.smartlockers.service.pasting.employee.PastedEmployeeEDPL;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/create-employees")
public class CreatingEmployeeController {

    private CreatingEmployeeService creatingEmployeeService;

    public CreatingEmployeeController(CreatingEmployeeService creatingEmployeeService) {
        this.creatingEmployeeService = creatingEmployeeService;
    }

    @PostMapping("/add-employees-edpl/{userId}")
    public StandardResponse addEmployeesEDPL(@PathVariable long userId, @RequestBody List<PastedEmployeeEDPL> employees) {
        return creatingEmployeeService.add(userId, employees);
    }

    @PostMapping("/set-department-position-location" +
            "/{departmentId}/{positionId}/{locationId}")
    public StandardResponse setDepartmentPositionLocation(
            @PathVariable long departmentId,
            @PathVariable long positionId,
            @PathVariable long locationId,
            @RequestBody Set<Long> employeesIds) {
        return creatingEmployeeService.setDepartmentPositionAndLocation(
                departmentId, positionId, locationId, employeesIds);
    }
}