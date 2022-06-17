package pl.bratosz.smartlockers.service.pasting;

import org.springframework.stereotype.Service;
import pl.bratosz.smartlockers.model.Client;
import pl.bratosz.smartlockers.model.Department;
import pl.bratosz.smartlockers.model.Location;
import pl.bratosz.smartlockers.model.Position;
import pl.bratosz.smartlockers.repository.ClientRepository;
import pl.bratosz.smartlockers.repository.UsersRepository;
import pl.bratosz.smartlockers.response.StandardResponse;
import pl.bratosz.smartlockers.service.DepartmentService;
import pl.bratosz.smartlockers.service.LocationService;
import pl.bratosz.smartlockers.service.PositionService;
import pl.bratosz.smartlockers.service.pasting.employee.EmployeeToAssign;
import pl.bratosz.smartlockers.service.pasting.employee.PastedEmployeeEDPL;

import java.util.List;

@Service
public class PastingEmployeeService {
    private UsersRepository usersRepository;
    private ClientRepository clientRepository;
    private DepartmentService departmentService;
    private LocationService locationService;
    private PositionService positionService;

    public PastingEmployeeService(UsersRepository usersRepository, ClientRepository clientRepository, DepartmentService departmentService, LocationService locationService, PositionService positionService) {
        this.usersRepository = usersRepository;
        this.clientRepository = clientRepository;
        this.departmentService = departmentService;
        this.locationService = locationService;
        this.positionService = positionService;
    }

    public StandardResponse add(long userId, List<PastedEmployeeEDPL> employees) {
        long clientId = usersRepository.getActualClientId(userId);
        Client client = clientRepository.getById(clientId);
        employees.forEach(e -> createEmployeeToAssign(e, client));
        return StandardResponse.createForSucceed();
    }

    private void createEmployeeToAssign(PastedEmployeeEDPL e, Client c) {
        System.out.println("Przed");

        Department d = departmentService.getByAliasAndClientId(e.getDepartment(), c.getId());
        Location l = locationService.getByNameAndClientId(e.getLocation(), c.getId());
        Position p = positionService.get(e.getPosition(), c);
        EmployeeToAssign employeeToAssign = new EmployeeToAssign();
        System.out.println("po");
    }
}

