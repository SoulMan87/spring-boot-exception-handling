package com.soulrebel.handling.servive;

import com.soulrebel.handling.model.Tutorial;

import java.util.List;
import java.util.Optional;

public interface TutorialService {

    List<Tutorial> getAllTutorials(String title);

    Optional<Tutorial> getTutorialById(long id);

    Optional<Tutorial> createTutorial(Tutorial tutorial);

    Optional<Tutorial> updateTutorial(long id, Tutorial tutorial);

    void deleteTutorial(long id);

    void deleteAllTutorials();

    List<Tutorial> findByPublished();
}
