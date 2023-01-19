package ir.maktab.service.serviceimpl;
import ir.maktab.madel.entity.Comments;
import ir.maktab.madel.entity.Expert;
import ir.maktab.madel.enumurated.ApprovalStatus;
import ir.maktab.repository.ExpertRepository;
import ir.maktab.service.ExpertService;
import javax.persistence.NoResultException;
import java.util.List;


public class ExpertServiceImpl implements ExpertService {
    private static final ExpertRepository expertRepository = new ExpertRepository();

    @Override
    public void expertRegistration(Expert expert) {
        expert.setApprovalStatus(ApprovalStatus.NEW);
        expert.setAverageScore(0);
        expertRepository.save(expert);
    }


    @Override
    public void update(Expert expert) {
        expertRepository.update(expert);
    }

    @Override
    public void deleteExpert(Expert expert) {
        expertRepository.delete(expert);
    }

    @Override
    public List<Expert> showAllOfExperts() {

        return expertRepository.getAll();
    }

    @Override
    public List<Expert> getExpertInNewStatus(ApprovalStatus approvalStatus) {
        return expertRepository.getExpertInNewStat(approvalStatus);
    }

    @Override
    public Expert logInExpert(String emailAddress, String password) {
        Expert expert = expertRepository.getByEmail(emailAddress).orElseThrow(() -> new NoResultException(" there is'nt any expert with this emailAddress!!"));
        if (expert.getPassword().equals(password))
            return expert;
        throw new NoResultException("is not exist password");
    }

    @Override
    public void updatePasswordByEmailAddress(String password, String emailAddress) {

        expertRepository.updatePasswordByEmailAddress(password, emailAddress);
    }
}
