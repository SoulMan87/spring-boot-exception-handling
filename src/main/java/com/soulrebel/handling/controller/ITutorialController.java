package com.soulrebel.handling.controller;

import com.soulrebel.handling.model.Tutorial;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Validated
@Tag(name = "Tutorials", description = "API that exposes certain endpoints of tutorials.")
public interface ITutorialController {

    @Operation(
            summary = "Retrieve all tutorials ",
            description = "Get all tutorials objects. The response are several tutorial objects with id, title, description and published status.",
            tags = {"Get Method"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Tutorial.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping(value = "/tutorials", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String tittle);

    @Operation(
            summary = "Retrieve a tutorial by Id",
            description = "Get a Tutorial object by specifying its id. The response is Tutorial object with id, title, description and published status.",
            tags = {"Get Method"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Tutorial.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping("/tutorials/{id}")
    ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id);

    @Operation(
            summary = "Create a tutorial ",
            description = "Create a tutorial object. The response is a created object with id, title, description and published status.",
            tags = {"Post Method"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Tutorial.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @PostMapping("/tutorials")
    ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial);

    @Operation(
            summary = "Update a tutorial ",
            description = "Update a tutorial object. The response is a updated object with id, title, description and published status.",
            tags = {"Put Method"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Tutorial.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @PutMapping("/tutorials/{id}")
    ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial);

    @Operation(
            summary = "Delete a tutorial ",
            description = "Delete a tutorial object. The response is a deleted object with id, title, description and published status.",
            tags = {"Delete Method"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Tutorial.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @DeleteMapping("/tutorials/{id}")
    ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id);

    @Operation(
            summary = "Delete all tutorials ",
            description = "Delete all tutorial objects. The response are deleted all objects with id, title, description and published status.",
            tags = {"Delete Method"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Tutorial.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @DeleteMapping("/tutorials")
    ResponseEntity<HttpStatus> deleteAllTutorials();

    @Operation(
            summary = "Retrieve all tutorials with that are published",
            description = "Get all tutorials objects that are published. The response are several tutorials objects with id, title, description and published status.",
            tags = {"Get Method"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Tutorial.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping("/tutorials/published")
    ResponseEntity<List<Tutorial>> findByPublished();
}
