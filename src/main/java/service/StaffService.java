package service;

import entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.StaffRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    private StaffRepository staffRepository;

    @Autowired
    public StaffService(StaffRepository repository) {
        staffRepository = repository;
    }

    public List<Staff> getAll() {
        return staffRepository.findAll();
    }

    public Staff getStaffById(Long id) {
        Optional<Staff> optionalStaff = staffRepository.findById(id);
        if (optionalStaff.isPresent()) {
            return optionalStaff.get();
        } else {
            throw new RuntimeException("No staff found for given id");
        }
    }

    public Staff AddNew(Staff staff) {
        Staff createdStaff = staffRepository.save(staff);
        return createdStaff;
    }
//
//    public Staff update(Staff updated) {
//    }
}
