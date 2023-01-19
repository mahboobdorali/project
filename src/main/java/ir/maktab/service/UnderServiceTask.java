package ir.maktab.service;

import ir.maktab.madel.entity.UnderService;

import java.util.List;

public interface UnderServiceTask {
    void saveUnderService(UnderService underService);
    void updateUnderService(UnderService underService);
    void deleteUnderService(UnderService underService);
    List<UnderService> showAllUnderService();
}
