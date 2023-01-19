package ir.maktab.service;

import ir.maktab.madel.entity.Service;

import java.util.List;

public interface DutyJobTaskService {
    void saveMainService(Service service);
    void updateMainService(Service service);
    void deleteMainService(Service service);
    List<Service> showAllMainService();
}
