package com.learnwithm.rms_api.service;

import com.learnwithm.rms_api.entity.Staff;
import com.learnwithm.rms_api.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    @Autowired
    public StaffService(StaffRepository repository) {
        staffRepository = repository;
    }

    /**
     * Get all staff members
     *
     * @return all staff member data
     */
    public List<Staff> getAll() {
        return staffRepository.findAll();
    }

    /**
     * Get staff member by Id
     *
     * @param id Id of the staff member
     * @return the staff member details of given id
     */
    public Staff getById(Long id) {
        Optional<Staff> optionalStaff = staffRepository.findById(id);
        if (optionalStaff.isPresent()) {
            return optionalStaff.get();
        } else {
            throw new RuntimeException("No staff found for given id");
        }
    }

    /**
     * Saving a new staff member
     *
     * @param newStaff staff member need to be saved
     * @return created staff member
     */
    public Staff save(Staff newStaff) {
        Staff createdStaff = staffRepository.save(newStaff);
        return createdStaff;
    }

    /**
     * Update an existing staff member
     *
     * @param details
     * @return updated staff member data
     */
    public Staff update(Long id, Staff details) {
        Optional<Staff> optionalExisting = staffRepository.findById(id);
        if (optionalExisting.isPresent()) {
            Staff existing = optionalExisting.get();

            Staff updatedData = updateStaffData(existing, details);
            return staffRepository.save(updatedData);
        } else {
            throw new RuntimeException("Selected staff member for given Id not present");
        }

    }

    /**
     * Delete a staff member
     *
     * @param staffId the ID of the staff member which need to be deleted
     */
    public void delete(Long staffId) {
        staffRepository.deleteById(staffId);
    }

    public Staff updateStaffData(Staff existing, Staff updated) {
        if (updated.getFirstName() != null) {
            existing.setFirstName(updated.getFirstName());
        }
        if (updated.getLastName() != null) {
            existing.setLastName(updated.getLastName());
        }


        return existing;
    }

}
