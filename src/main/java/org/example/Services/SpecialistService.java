package org.example.Services;

import org.example.DAO.SpecialistDAO;
import org.example.Classes.Specialist;

import java.util.ArrayList;

public class SpecialistService {

    private SpecialistDAO SpecialistsDao = new SpecialistDAO();

    public SpecialistService() {
    }

    public Specialist findSpecialist(int id) {
        return SpecialistsDao.findById(id);
    }

    public void insertSpecialist(Specialist specialist) {
        SpecialistsDao.insert(specialist);
    }

    public void deleteSpecialist(Specialist specialist) {
        SpecialistsDao.delete(specialist);
    }

    public void updateSpecialist(Specialist specialist) {
        SpecialistsDao.update(specialist);
    }

    public ArrayList<Specialist> findAllSpecialists() {
        return SpecialistsDao.findAll();
    }
}
