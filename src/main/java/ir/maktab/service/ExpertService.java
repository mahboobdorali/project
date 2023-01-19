package ir.maktab.service;

import ir.maktab.madel.entity.Expert;
import ir.maktab.madel.enumurated.ApprovalStatus;

import java.util.List;
import java.util.Optional;

public interface ExpertService {
    void expertRegistration(Expert expert);
    void update(Expert expert);
    void deleteExpert(Expert expert);
    List<Expert> showAllOfExperts();
    Expert getExpertInNewStatus(ApprovalStatus approvalStatus);
    Expert logInExpert(String emailAddress,String password);
    void updatePasswordByEmailAddress(String password, String emailAddress);
}
