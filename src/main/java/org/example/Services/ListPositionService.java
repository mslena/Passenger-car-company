package org.example.Services;

import lombok.AllArgsConstructor;
import org.example.DAO.ListPositionDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListPositionService {

    private final ListPositionDAO listPositionDAO;

    public List getAll() {
        return listPositionDAO.getAll();
    }

    public void setAll(String id_staff, String id_post, String work_experience, String salary) {
        listPositionDAO.setAll(Integer.parseInt(id_staff), Integer.parseInt(id_post),work_experience, salary);
    }

    public void update(String id_staff, String id_post, String work_experience, String salary) {

        if(!work_experience.isEmpty()){
            listPositionDAO.updateWorkExperience(Integer.parseInt(id_staff), Integer.parseInt(id_post), work_experience);
        }
        if(!salary.isEmpty()){
            listPositionDAO.updateSalary(Integer.parseInt(id_staff), Integer.parseInt(id_post), salary);
        }
    }

    public void delete(String id_staff, String id_post) {
        listPositionDAO.delete(Integer.parseInt(id_staff), Integer.parseInt(id_post));
    }
}
