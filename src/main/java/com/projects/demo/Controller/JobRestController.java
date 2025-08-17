package com.projects.demo.Controller;

import com.projects.demo.Models.JobPost;
import com.projects.demo.Models.JobReponse;
import com.projects.demo.Services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class JobRestController {

    @Autowired
    private JobService jobservice;

    // To fetch list of Jobs
    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs() {
        return jobservice.getAllJobs();
    }

    // Get a job by id
    @GetMapping("/jobPosts/{jobPostID}")
    public Optional<JobPost> getAJob(@PathVariable("jobPostID") int jobPostID) {
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
}
