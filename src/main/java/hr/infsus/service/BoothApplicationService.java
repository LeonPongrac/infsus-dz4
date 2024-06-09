package hr.infsus.service;

import hr.infsus.dto.BoothApplicationInput;
import hr.infsus.dto.BoothApplicationView;
import hr.infsus.model.BoothApplication;
import hr.infsus.repository.BoothApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoothApplicationService {
    @Autowired
    private BoothApplicationRepository repository;

    public BoothApplication saveBoothApplication(BoothApplicationInput input) {
        BoothApplication boothApplication = new BoothApplication();
        boothApplication.setName(input.getName());
        boothApplication.setEmail(input.getEmail());
        boothApplication.setPhone(input.getPhone());
        boothApplication.setBoothNumber(input.getBoothNumber());
        boothApplication.setBoothName(input.getBoothName());
        boothApplication.setBoothDetails(input.getBoothDetails());
        boothApplication.setStatus("PENDING");
        boothApplication.setPaid(false);

        return repository.save(boothApplication);
    }

    public List<BoothApplication> getAllApplications() {
        return repository.findAll();
    }

    public List<BoothApplicationView> getAllViewApplications() {
        List<BoothApplication> boothApplications = repository.findAll();
        return boothApplications.stream()
                .map(BoothApplicationView::new)
                .collect(Collectors.toList());
    }

    public void approveApplication(Long id) {
        BoothApplication application = repository.findById(id).orElse(null);
        if (application != null) {
            application.setStatus("APPROVED");
            repository.save(application);
        }
    }

    public void rejectApplication(Long id) {
        BoothApplication application = repository.findById(id).orElse(null);
        if (application != null) {
            application.setStatus("REJECTED");
            repository.save(application);
        }
    }

    public double calculateBill(int boothNumber) {
        if (boothNumber >= 1 && boothNumber <= 20)
            return 100.0;
        else if (boothNumber >= 21 && boothNumber <= 50)
            return 75.0;
        else
            return 50.0;
    }
}
