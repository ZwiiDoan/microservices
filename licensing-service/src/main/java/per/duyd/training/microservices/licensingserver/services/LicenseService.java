package per.duyd.training.microservices.licensingserver.services;

import per.duyd.training.microservices.licensingserver.model.License;

import java.util.List;

public interface LicenseService {
    License getLicense(String organizationId, String licenseId);

    List<License> getLicensesByOrg(String organizationId);

    void saveLicense(License license);

    void updateLicense(License license);

    void deleteLicense(License license);
}
