package com.projects.demo.Controller;

import com.projects.demo.Models.JobPost;
import com.projects.demo.Models.JobReponse;
import com.projects.demo.Services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class JobRestController {

    @Autowired
    private JobService jobservice;

    // To fetch list of Jobs
    @GetMapping("jobPosts")
    public JobReponse getAllJobs() {
        return jobservice.getAllJobs();
    }

    // Get a job by id
    @GetMapping("/jobPosts/{jobPostID}")
    public JobPost getAJob(@PathVariable("jobPostID") int jobPostID) {
        return jobservice.getAJob(jobPostID);
    }

//Modifies by Patch method
    @PatchMapping("/jobPosts")
    public JobPost modifyAJob(@RequestBody JobPost jobPost) {
        jobservice.ModifyAJob(jobPost);
        return jobservice.getAJob(jobPost.getPostId());
    }

    //Replaces by PUT method
    @PutMapping("/jobPosts")
    public JobPost replaceAJob(@RequestBody JobPost jobPost) {
         jobservice.replaceAJob(jobPost);
         return jobservice.getAJob(jobPost.getPostId());
    }


// Creates a new Job
    @PostMapping("/jobPosts")
    public JobReponse createJobs(@RequestBody List<JobPost> jobPosts) {
        return jobservice.saveAll(jobPosts);
    }



    //  Deletes a job
    @DeleteMapping("/jobPosts/{PostID}")
    public String deleteAjob(@PathVariable int PostID) {
         jobservice.deleteAjob(PostID);
         return "Deleted job with PostID :"+ PostID;
    }
}
