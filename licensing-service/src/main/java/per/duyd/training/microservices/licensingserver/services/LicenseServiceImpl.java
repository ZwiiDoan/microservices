package per.duyd.training.microservices.licensingserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.duyd.training.microservices.licensingserver.model.License;
import per.duyd.training.microservices.licensingserver.repository.LicenseRepository;

import java.util.List;
import java.util.UUID;

@Service
public class LicenseServiceImpl implements LicenseService {

    @Autowired
    private LicenseRepository licenseRepository;

    @Override
    public License getLicense(String organizationId, String licenseId) {
        return licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
    }

    @Override
    public List<License> getLicensesByOrg(String organizationId) {
        return licenseRepository.findByOrganizationId(organizationId);
    }

    public void saveLicense(License license) {
        licenseRepository.save(license.withId(UUID.randomUUID().toString()));
    }

    public void updateLicense(License license) {
        licenseRepository.save(license);
    }

    public void deleteLicense(License license) {
        licenseRepository.delete(license);
    }
}
