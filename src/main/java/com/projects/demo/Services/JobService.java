package com.projects.demo.Services;

import com.projects.demo.Models.JobPost;
import com.projects.demo.Models.JobReponse;
import com.projects.demo.Repositories.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobService {
    @Autowired
    public JobRepo jobrepo;

    // To fetch list of Jobs

    public JobReponse getAllJobs() {
     List<JobPost>  jobs= jobrepo.getAllJobs();
        return new JobReponse(jobs.size(),jobs);
    }

    // Get a job
    public JobPost getAJob(int jobPostID) {
        return jobrepo.getAJob(jobPostID);
//        return new JobReponse(jobs.size(),jobs);
    }


//    public JobPost getPostId() {
//
//        return jobrepo.getJob(1);
//    }

    // Creates a List of New Job/s
    public JobReponse saveAll(List<JobPost> jobPosts) {
        List<JobPost> jobs =  jobrepo.saveAll(jobPosts);
        return new JobReponse(jobs.size(),jobs); // full list
    }

// Modifies by Patch method
    public void ModifyAJob(JobPost jobPost) {
        jobrepo.ModifyAJob(jobPost);
    }

    //Replaces by Put method
    public void replaceAJob(JobPost jobPost) {
        jobrepo.replaceAJob(jobPost);
    }

    //Deletes a job
    public void deleteAjob(int postID) {
        jobrepo.deleteAjob(postID);
    }
}
