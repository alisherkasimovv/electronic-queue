package uz.queue.services.dao.interfaces;

import uz.queue.models.Department;
import uz.queue.models.Service;

import java.util.List;

public interface ServiceDAO {

    List<Service> getAll();

    List<Service> getAllByDepartmentId(int departmentId);
    Service getServiceById(int id);
    void saveService(Service service);
    void editService(Service service);
    void deleteService(int id);

    List<Service> getServicesForDepartment(Department department);

}
