package com.projects.demo.controller;

import com.projects.demo.models.JobPost;
import com.projects.demo.services.JobService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springdoc.core.models.GroupedOpenApi;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.web.csrf.CsrfToken;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/api/v1")
@Tag(name = "Job Management", description = "APIs for managing job posts")
public class JobRestController_v1 {

    @Autowired
    private JobService jobservice;


    // To fetch list of Jobs
    @GetMapping("/jobPosts")
    @Operation(summary = "Fetch all jobs", description = "Returns a list of all job posts available in the system")
    public List<JobPost> getAllJobs() {
        return jobservice.getAllJobs();
    }

    // Get a job by id

    @Operation(summary = "Fetch a job by ID", description = "Retrieve details of a specific job post using its ID")
    @GetMapping("/jobPosts/{jobPostID}")
    public Optional<JobPost> getAJob(@Parameter(description = "ID of the job to retrieve")
                                     @PathVariable("jobPostID") int jobPostID) {
        return jobservice.getAJob(jobPostID);
    }

//Modifies by Patch method
//    @PatchMapping("/jobPosts")
//    public JobPost modifyAJob(@RequestBody JobPost jobPost) {
//        jobservice.ModifyAJob(jobPost);
//        return jobservice.getAJob(jobPost.getPostId());
//    }

    //Replaces by PUT method
    @PutMapping("/jobPosts")
    public Optional<JobPost> replaceAJob(@RequestBody JobPost jobPost) {
         jobservice.replaceAJob(jobPost);
         return jobservice.getAJob(jobPost.getPostId());
    }


// Creates a new Job

    @Operation(summary = "Create a new job post", description = "Add a new job post to the system")
    @ApiResponse(responseCode = "200", description = "Job created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input provided")
    @PostMapping("/jobPosts")
    public JobPost createJobs(@RequestBody JobPost jobPost) {
        return jobservice.saveAll(jobPost);
    }


    //  Deletes a job
    @DeleteMapping("/jobPosts/{PostID}")
    public String deleteAjob(@PathVariable int PostID) {
         jobservice.deleteAjob(PostID);
         return "Deleted job with PostID :"+ PostID;
    }

    @GetMapping("/loadData")
    public ResponseEntity<String> loadData() {
        try {
            jobservice.loadData();
            return ResponseEntity.ok("Sample data loaded successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){

        return (CsrfToken)request.getAttribute("_csrf");
    }

}
