package ir.maktab.service.serviceimpl;

import ir.maktab.exception.DuplicateEntryException;
import ir.maktab.madel.entity.Expert;
import ir.maktab.madel.entity.Service;
import ir.maktab.madel.entity.UnderService;
import ir.maktab.madel.enumurated.ApprovalStatus;

import java.util.List;

public class AdminImpl {
    private static final UnderServiceImpl underServiceImpl = new UnderServiceImpl();
    private static final DutyJobTaskImpl mainService = new DutyJobTaskImpl();
    private static final ExpertServiceImpl expertServiceImpl = new ExpertServiceImpl();
    private static Expert expert = new Expert();

    public void showAllOfUnderServiceByAdmin() {

        underServiceImpl.showAllUnderService();
    }


    public void showAllOfMainServiceByAdmin() {

        mainService.showAllMainService();
    }

    public Expert convertStatus(Expert expert) {
        Expert expertInNewStatus = expertServiceImpl.getExpertInNewStatus(expert.getApprovalStatus());
      expert.setApprovalStatus(ApprovalStatus.ACCEPTED);
      expertServiceImpl.update(expert);
        return expertInNewStatus;
    }

    public void addExpertToUnderService(UnderService subService) {
        List<UnderService> underServices1 = underServiceImpl.showAllUnderService();
        if (underServices1.toString().contains(subService.getNameSubService())) {
            expert.getUnderServiceList().add(subService);
            expertServiceImpl.update(expert);
        }
    }

    public void deleteExpertFromUnderService(UnderService underService) {
        expert.getUnderServiceList().remove(underService);
        expertServiceImpl.update(expert);
    }

    public void updateFieldsOfUnderService(UnderService underService) {
        underServiceImpl.updateUnderService(underService);
    }


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