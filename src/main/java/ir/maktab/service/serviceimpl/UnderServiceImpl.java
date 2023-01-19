package ir.maktab.service.serviceimpl;

import ir.maktab.exception.DuplicateEntryException;
import ir.maktab.madel.entity.UnderService;
import ir.maktab.repository.UnderServiceRepository;
import ir.maktab.service.UnderServiceTask;

import java.util.HashSet;
import java.util.List;

public class UnderServiceImpl implements UnderServiceTask {
    private static final UnderServiceRepository underServiceRepository = new UnderServiceRepository();

    @Override
    public void saveUnderService(UnderService underService) {

        underServiceRepository.save(underService);
    }

    @Override
    public void updateUnderService(UnderService underService) {

        underServiceRepository.update(underService);
    }

    @Override
    public void deleteUnderService(UnderService underService) {

        underServiceRepository.delete(underService);
    }

    @Override
    public List<UnderService> showAllUnderService() {

        return underServiceRepository.getAll();
    }




}
