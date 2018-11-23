package per.duyd.training.microservices.licensingserver.repository;

import org.springframework.data.repository.CrudRepository;
import per.duyd.training.microservices.licensingserver.model.License;

import java.util.List;

public interface LicenseRepository extends CrudRepository<License, String> {
    List<License> findByOrganizationId(String organizationId);

    License findByOrganizationIdAndLicenseId(String organizationId, String licenseId);
}
