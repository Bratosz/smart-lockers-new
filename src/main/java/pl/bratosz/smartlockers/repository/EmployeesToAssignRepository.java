package pl.bratosz.smartlockers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bratosz.smartlockers.service.pasting.employee.EmployeeToAssign;

@Repository
public interface EmployeesToAssignRepository extends JpaRepository<EmployeeToAssign, Long> {

}
