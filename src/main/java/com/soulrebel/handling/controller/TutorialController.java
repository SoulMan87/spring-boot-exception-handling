package com.soulrebel.handling.controller;

import com.soulrebel.handling.model.Tutorial;
import com.soulrebel.handling.servive.TutorialService;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TutorialController implements ITutorialController {

    private final TutorialService service;

    @Override
    public ResponseEntity<List<Tutorial>> getAllTutorials(String title) {
        var tutorials = service.getAllTutorials (title);
        if (tutorials.isEmpty ()) {
            return new ResponseEntity<> (HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<> (tutorials, HttpStatus.OK);
    }

    public ResponseEntity<Tutorial> getTutorialById(long id) {
        var tutorial = service.getTutorialById (id);
        return new ResponseEntity<> (tutorial.get (), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Tutorial> createTutorial(Tutorial tutorial) {
        var tutorialOptional = service.createTutorial (tutorial);
        return new ResponseEntity<> (tutorialOptional.get (), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Tutorial> updateTutorial(long id, Tutorial tutorial) {
        var updatedTutorial = service.updateTutorial (id, tutorial);
        return new ResponseEntity<> (updatedTutorial.get (), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteTutorial(long id) {
        service.deleteTutorial (id);
        return new ResponseEntity<> (HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        service.deleteAllTutorials ();
        return new ResponseEntity<> (HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<Tutorial>> findByPublished() {
        var tutorials = service.findByPublished ();
        if (tutorials.isEmpty ()) {
            return new ResponseEntity<> (HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<> (tutorials, HttpStatus.OK);
    }
}
