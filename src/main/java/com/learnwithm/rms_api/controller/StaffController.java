package com.learnwithm.rms_api.controller;

import com.learnwithm.rms_api.entity.Staff;
import com.learnwithm.rms_api.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    /**
     * Get all staff members
     *
     * @return Response entity with status 200(OK) with all staff member details
     */
    @GetMapping("/")
    public ResponseEntity<List<Staff>> getAllUsers() {
        return ResponseEntity.ok(staffService.getAll());
    }

    /**
     * Get staff member for given Id
     *
     * @param id Id of the staff member
     * @return Response entity with status 200(OK) and staff member for given Id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Staff> getById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(staffService.getById(id));
    }

    /**
     * Saving a new staff member
     *
     * @param staffMember
     * @return ResponseEntity with 200(OK) with newly added staff member
     */
    @PostMapping("/")
    public ResponseEntity<Staff> create(@RequestBody Staff staffMember) {
        return ResponseEntity.ok(staffService.save(staffMember));
    }

    /**
     * Update the given staff member
     *
     * @param id                 Id of the staff member
     * @param updatedStaffMember Updated details of the staff member
     * @return Response entity with status 200(OK) and updated staff member details
     */
    @PutMapping("/{id}")
    public ResponseEntity<Staff> update(@PathVariable(value = "id") Long id, @RequestBody Staff updatedStaffMember) {
        return ResponseEntity.ok(staffService.update(id, updatedStaffMember));
    }

    /**
     * Deleting a staff member
     *
     * @param id Id of the deletable staff member
     * @return Response entity with status 200(OK)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(value = "id") Long id) {
        staffService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
