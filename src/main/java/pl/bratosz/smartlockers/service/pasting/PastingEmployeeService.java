package pl.bratosz.smartlockers.service.pasting;

import org.springframework.stereotype.Service;
import pl.bratosz.smartlockers.service.pasting.employee.PastedEmployeeEDPL;

import java.util.List;

@Service
public class PastingEmployeeService {

    public void add(long userId, List<PastedEmployeeEDPL> employees) {
        System.out.println("foo");

    }
}
