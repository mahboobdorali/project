package ir.maktab.service.serviceimpl;

import ir.maktab.madel.entity.Service;
import ir.maktab.repository.ServiceRepository;
import ir.maktab.service.DutyJobTaskService;

import java.util.List;

public class DutyJobTaskImpl implements DutyJobTaskService {
    private static final ServiceRepository serviceRepository = new ServiceRepository();

    @Override
    public void saveMainService(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void updateMainService(Service service) {
        serviceRepository.update(service);
    }

    @Override
    public void deleteMainService(Service service) {
        serviceRepository.delete(service);
    }

    @Override
    public List<Service> showAllMainService() {

        return serviceRepository.getAll();
    }
}
