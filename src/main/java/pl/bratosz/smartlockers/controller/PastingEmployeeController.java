package pl.bratosz.smartlockers.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import pl.bratosz.smartlockers.service.pasting.PastingEmployeeService;
import pl.bratosz.smartlockers.service.pasting.employee.PastedEmployeeEDPL;
import pl.bratosz.smartlockers.utils.EmployeeName;
import pl.bratosz.smartlockers.utils.NameExtractor;

import java.text.Normalizer;
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

    @PostMapping("/test")
    public void test() {
        String s = "zażółć gęślą jaźń";
        StringBuilder sb = new StringBuilder(s.length());
        s = Normalizer.normalize(s, Normalizer.Form.NFD);
        for (char c : s.toCharArray()) {
            if (c <= '\u007F') sb.append(c);
        }
        System.out.println(sb.toString());
}
}
