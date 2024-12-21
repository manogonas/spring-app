package org.example.Services;

import org.example.DAO.StoryDAO;
import org.example.Classes.Story;

import java.util.ArrayList;

public class StoryService {

    private StoryDAO storyDao = new StoryDAO();

    public StoryService() {
    }

    public Story findStory(int id) {
        return storyDao.findById(id);
    }

    public void insertStory(Story Story) {
        storyDao.insert(Story);
    }

    public void deleteStory(Story Story) {
        storyDao.delete(Story);
    }

    public void updateStory(Story Story) {
        storyDao.update(Story);
    }

    public ArrayList<Story> findAllStories() {
        return storyDao.findAll();
    }
}
