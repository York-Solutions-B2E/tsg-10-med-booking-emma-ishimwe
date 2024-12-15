package com.york.medical.specialization;

import com.york.medical.dto.CommonApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/specializations")
public class SpecializationController {

    private final SpecializationService specializationService;

    @Autowired
    public SpecializationController(SpecializationService specializationService) {
        this.specializationService = specializationService;
    }

    @GetMapping
    public ResponseEntity<SpecializationResponseDto> fetchAllSpecialization() {
        return specializationService.fetchAllSpecialization();
    }

    @PostMapping("/add")
    public ResponseEntity<CommonApiResponse> addSpecialization(@RequestBody Specialization specialization) {
        return specializationService.addSpecialization(specialization);
    }

    @PutMapping("/update")
    public ResponseEntity<CommonApiResponse> updateSpecialization(@RequestBody Specialization specialization) {
        return specializationService.updateSpecialization(specialization);
    }

}
