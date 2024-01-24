package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Classes.Staff;
import org.example.Interface.DAO;
import org.example.Mapper.StaffMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class StaffDAO implements DAO {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List getAll() {
        String SQL = "SELECT * FROM STAFF";
        List<Staff> staff = jdbcTemplate.query(SQL, new StaffMapper());
        return staff;
    }

    public int setAll(String full_name, String date_of_birth, String phone_number, String address, String passport_details, String work_book_number) {
        String SQL = "INSERT INTO STAFF\n" +
                "(id_staff, full_name, date_of_birth, phone_number, address, passport_details, work_book_number) \n"+
                "VALUES (abs(dbms_random.random), ?, TO_DATE(? ,'YYYY-MM-DD'), ?, ?, ?, ?)";
        return jdbcTemplate.update(SQL,full_name, date_of_birth, phone_number, address, passport_details, work_book_number);
    }

    public void updateFullName(int id_staff, String full_name){
        String SQL = "UPDATE STAFF\n" +
                "SET full_name = ?" +
                "WHERE id_staff = ?";
        jdbcTemplate.update(SQL, full_name, id_staff);
    }

    public void updateDateOfBirth(int id_staff, String date_of_birth){
        String SQL = "UPDATE STAFF\n" +
                "SET date_of_birth = TO_DATE(? ,'YYYY-MM-DD')" +
                "WHERE id_staff = ?";
        jdbcTemplate.update(SQL, date_of_birth, id_staff);
    }

    public void updatePhoneNumber(int id_staff, String phone_number){
        String SQL = "UPDATE STAFF\n" +
                "SET  phone_number = ?" +
                "WHERE id_staff = ?";
        jdbcTemplate.update(SQL, phone_number, id_staff);
    }

    public void updateAddress(int id_staff,String address){
        String SQL = "UPDATE STAFF\n" +
                "SET address = ?" +
                "WHERE id_staff = ?";
        jdbcTemplate.update(SQL, address, id_staff);
    }

    public void updatePassportDetails(int id_staff, String passport_details){
        String SQL = "UPDATE STAFF\n" +
                "SET passport_details = ?" +
                "WHERE id_staff = ?";
        jdbcTemplate.update(SQL, passport_details, id_staff);
    }

    public void updateWorkBookNumber(int id_staff, String work_book_number){
        String SQL = "UPDATE STAFF\n" +
                "SET work_book_number = ?" +
                "WHERE id_staff = ?";
        jdbcTemplate.update(SQL, work_book_number, id_staff);
    }

    public void delete(int id_staff){
        String SQL = "DELETE FROM STAFF\n" +
                "WHERE ID_STAFF = ?";
        jdbcTemplate.update(SQL, id_staff);
    }
}
