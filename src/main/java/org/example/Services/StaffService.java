package org.example.Services;

import lombok.AllArgsConstructor;
import org.example.DAO.StaffDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StaffService {

    private final StaffDAO staffDAO;

    public List getAll(){
        return staffDAO.getAll();
    }

    public void setAll(String full_name, String date_of_birth, String phone_number, String address, String passport_details, String work_book_number){
        staffDAO.setAll(full_name,  date_of_birth , phone_number, address, passport_details, work_book_number);
    }

    public void update(String id_staff, String full_name, String date_of_birth, String phone_number, String address, String passport_details, String work_book_number){
        if(!full_name.isEmpty()){
            staffDAO.updateFullName(Integer.parseInt(id_staff), full_name);
        }
        if(!date_of_birth.isEmpty()){
            staffDAO.updateDateOfBirth(Integer.parseInt(id_staff), date_of_birth);
        }
        if(!phone_number.isEmpty()){
            staffDAO.updatePhoneNumber(Integer.parseInt(id_staff), phone_number);
        }
        if(!address.isEmpty()){
            staffDAO.updateAddress(Integer.parseInt(id_staff), address);
        }
        if(!passport_details.isEmpty()){
            staffDAO.updatePassportDetails(Integer.parseInt(id_staff), passport_details);

        }
        if(!work_book_number.isEmpty()){
            staffDAO.updateWorkBookNumber(Integer.parseInt(id_staff) ,work_book_number);
        }
    }

    public void delete(String id_staff){
        staffDAO.delete(Integer.parseInt(id_staff));
    }
}
