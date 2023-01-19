package ir.maktab.service;

import ir.maktab.exception.DuplicateEntryException;
import ir.maktab.madel.entity.Expert;
import ir.maktab.madel.entity.Service;
import ir.maktab.madel.entity.UnderService;
import ir.maktab.madel.enumurated.ApprovalStatus;

import java.util.List;

public interface AdminService {
    void showAllOfUnderServiceByAdmin();
    void showAllOfMainServiceByAdmin();
    List<Expert> expertListWhereStatusNew(ApprovalStatus status);
    void updateFieldsOfUnderService(UnderService underService);
    void conditionForAddUnderServiceAndService(UnderService underService11, Service service11) throws DuplicateEntryException;
}
