package com.soulrebel.handling.service;

import com.soulrebel.handling.exception.ResourceNotFoundException;
import com.soulrebel.handling.model.Tutorial;
import com.soulrebel.handling.repository.TutorialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TutorialServiceImpl implements TutorialService {

    private static final String NOT_FOUND_TUTORIAL = "Not found Tutorial with id = ";

    private final TutorialRepository repository;

    @Override
    public List<Tutorial> getAllTutorials(String title) {

        if (title == null) {
            return (List<Tutorial>) repository.findAll ();
        } else return repository.findByTitleContaining (title);
    }

    @Override
    public Optional<Tutorial> getTutorialById(long id) {
        return Optional.of (repository.findById (id)
                .orElseThrow (() -> new ResourceNotFoundException (NOT_FOUND_TUTORIAL + id)));
    }

    @Override
    public Optional<Tutorial> createTutorial(Tutorial tutorial) {
        return Optional.of (repository.save (tutorialBuilder (tutorial)));
    }

    @Override
    public Optional<Tutorial> updateTutorial(long id, Tutorial tutorial) {

        var existingTutorial = repository.findById (id)
                .orElseThrow (() -> new ResourceNotFoundException (NOT_FOUND_TUTORIAL + id));
        return Optional.of (repository.save (buildUpdatedTutorial (existingTutorial)));
    }

    @Override
    public void deleteTutorial(long id) {
        repository.deleteById (id);
    }

    @Override
    public void deleteAllTutorials() {
        repository.deleteAll ();
    }

    @Override
    public List<Tutorial> findByPublished() {
        return repository.findByPublished (true);
    }

    private Tutorial tutorialBuilder(Tutorial tutorial) {
        return Tutorial.builder ()
                .title (tutorial.getTitle ())
                .description (tutorial.getDescription ())
                .published (false)
                .build ();
    }

    private Tutorial buildUpdatedTutorial(Tutorial tutorial) {
        return Tutorial.builder ()
                .id (tutorial.getId ())
                .title (tutorial.getTitle ())
                .description (tutorial.getDescription ())
                .published (tutorial.isPublished ())
                .build ();
    }
}
