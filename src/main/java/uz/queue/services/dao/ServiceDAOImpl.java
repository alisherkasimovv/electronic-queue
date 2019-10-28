package uz.queue.services.dao;

import org.springframework.beans.factory.annotation.Autowired;
import uz.queue.models.Department;
import uz.queue.models.Service;
import uz.queue.repositories.ServiceRepository;
import uz.queue.services.dao.interfaces.ServiceDAO;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceDAOImpl implements ServiceDAO {

    private ServiceRepository repository;

    @Autowired
    public ServiceDAOImpl(ServiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Service> getAll() {
        return repository.findAll();
    }

    @Override
    public Service getServiceById(int id) {
        return repository.findById(id);
    }

    @Override
    public void saveService(Service service) {
        repository.save(service);
    }

    @Override
    public void editService(Service service) {
        Service temp = repository.findById(service.getId());

        temp.setName(service.getName());
        temp.setDescription(service.getDescription());

        repository.save(temp);
    }

    @Override
    public void deleteService(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Service> getServicesForDepartment(Department department) {
        return repository.findServicesByDepartment(department);
    }
}
