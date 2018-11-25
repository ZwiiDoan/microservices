package per.duyd.training.microservices.licensingserver.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import per.duyd.training.microservices.licensingserver.model.License;
import per.duyd.training.microservices.licensingserver.services.LicenseService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final LicenseService licenseService;

    @Value("${my.custom.property}")
    private int myCustomProperty;

    @Autowired
    public LicenseServiceController(LicenseService licenseService) {
        this.licenseService = licenseService;
    }

    @RequestMapping(value = "/custom-properties", method = RequestMethod.GET)
    public Map<String, String> showCustomProperties() {
        Map<String, String> customProperties = new HashMap<>();
        customProperties.put("myCustomProperty", String.valueOf(myCustomProperty));
        return customProperties;
    }

    @RequestMapping(value = "/{licenseId}", method = RequestMethod.GET)
    public License getLicenses(@PathVariable("organizationId") String organizationId,
                               @PathVariable("licenseId") String licenseId) {
        return licenseService.getLicense(organizationId, licenseId);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<License> getLicenses(@PathVariable("organizationId") String organizationId) {
        return licenseService.getLicensesByOrg(organizationId);
    }


    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public void updateLicenses(@RequestBody License license) {
        licenseService.updateLicense(license);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void saveLicenses(@RequestBody License license) {
        licenseService.saveLicense(license);
    }

    @RequestMapping(value = "/{licenseId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLicenses(@PathVariable("organizationId") String organizationId,
                               @PathVariable("licenseId") String licenseId) {
        License licenseToDelete = licenseService.getLicense(organizationId, licenseId);
        licenseService.deleteLicense(licenseToDelete);
    }

}
