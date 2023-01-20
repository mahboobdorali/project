package ir.maktab.service.serviceimpl;

import ir.maktab.madel.entity.Comments;
import ir.maktab.madel.entity.Expert;
import ir.maktab.madel.enumurated.ApprovalStatus;
import ir.maktab.repository.ExpertRepository;
import ir.maktab.service.ExpertService;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.persistence.NoResultException;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
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
    public Expert getExpertInNewStatus(ApprovalStatus approvalStatus) {
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

    public void image(File imageFile, Expert expert) throws IOException {
        final int SIZE = 0;
        ImageInputStream imageInputStream = ImageIO.createImageInputStream(imageFile);
        Iterator<ImageReader> imageReadersList = ImageIO.getImageReaders(imageInputStream);
        if (!imageReadersList.hasNext()) {
            throw new NoResultException("Image  Not Found!!!");
        }
        ImageReader image = imageReadersList.next();
        String formatName = image.getFormatName();
        if (formatName.equals("jpg") && SIZE <= 300000) {
            expertRegistration(expert);
        }
        imageInputStream.close();
    }
}

