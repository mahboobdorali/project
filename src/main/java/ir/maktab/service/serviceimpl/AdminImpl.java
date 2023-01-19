package ir.maktab.service.serviceimpl;

import ir.maktab.exception.DuplicateEntryException;
import ir.maktab.madel.entity.Expert;
import ir.maktab.madel.entity.Service;
import ir.maktab.madel.entity.UnderService;
import ir.maktab.madel.enumurated.ApprovalStatus;
import ir.maktab.service.AdminService;

import javax.persistence.NoResultException;
import java.util.List;

public class AdminImpl implements AdminService {
    private static final UnderServiceImpl underServiceImpl = new UnderServiceImpl();
    private static final DutyJobTaskImpl mainService = new DutyJobTaskImpl();
    private static final ExpertServiceImpl expertServiceImpl = new ExpertServiceImpl();
    private static final UnderService underservice = new UnderService();
    private final Expert expert = new Expert();

    @Override
    public void showAllOfUnderServiceByAdmin() {

        underServiceImpl.showAllUnderService();
    }

    @Override
    public void showAllOfMainServiceByAdmin() {

        mainService.showAllMainService();
    }

    @Override
    public List<Expert> expertListWhereStatusNew(ApprovalStatus status) {
        List<Expert> expertInNewStatus = expertServiceImpl.getExpertInNewStatus(status);
        for (Expert list : expertInNewStatus) {
            list.setApprovalStatus(ApprovalStatus.ACCEPTED);
            expertServiceImpl.update(list);
        }
        return expertInNewStatus;
    }

    @Override
    public void updateFieldsOfUnderService(UnderService underService) {
        underServiceImpl.updateUnderService(underService);
    }

    @Override
    public void conditionForAddUnderServiceAndService(UnderService underService11, Service service11) throws DuplicateEntryException {
        List<UnderService> underServices1 = underServiceImpl.showAllUnderService();
        List<Service> services = mainService.showAllMainService();
        if (services.toString().contains(service11.getName()) && underServices1.toString().contains(underService11.getNameSubService())) {
            throw new DuplicateEntryException("entry is duplicated");
        } else {
            underServiceImpl.saveUnderService(underService11);
            underServiceImpl.updateUnderService(underService11);
            mainService.saveMainService(service11);
            mainService.updateMainService(service11);
        }
    }
}