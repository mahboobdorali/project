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

    public void showAllOfUnderServiceByAdmin() {
        underServiceImpl.showAllUnderService();
    }

    public void showAllOfMainServiceByAdmin() {
        mainService.showAllMainService();
    }

    public List<Expert> expertListWhereStatusNew(ApprovalStatus status) {
        List<Expert> expertInNewStatus = expertServiceImpl.getExpertInNewStatus(status);
        for (Expert list : expertInNewStatus) {
            list.setApprovalStatus(ApprovalStatus.ACCEPTED);
            expertServiceImpl.update(list);
        }
        return expertInNewStatus;
    }

    public void updateFieldsOfUnderService(UnderService underService) {
        underServiceImpl.updateUnderService(underService);
    }

    public void conditionForAddUnderServiceAndService(UnderService underService) throws DuplicateEntryException {
        List<UnderService> underServices1 = underServiceImpl.showAllUnderService();
       // List<Service> services = mainService.showAllMainService();
       if(underServices1.contains(underService.getNameSubService()))
           throw new DuplicateEntryException("entry is duplicated");

       else
          // mainService.saveMainService(service1);
         underServiceImpl.saveUnderService(underService);

    }
}