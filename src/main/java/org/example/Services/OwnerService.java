package org.example.Services;

import org.example.DAO.OwnerDAO;
import org.example.Classes.Owner;

import java.util.ArrayList;

public class OwnerService {

    private OwnerDAO ownersDao = new OwnerDAO();

    public OwnerService() {
    }

    public Owner findOwner(int id) {
        return ownersDao.findById(id);
    }

    public void insertOwner(Owner owner) {
        ownersDao.insert(owner);
    }

    public void deleteOwner(Owner owner) {
        ownersDao.delete(owner);
    }

    public void updateOwner(Owner owner) {
        ownersDao.update(owner);
    }

    public ArrayList<Owner> findAllOwners() {
        return ownersDao.findAll();
    }
}
