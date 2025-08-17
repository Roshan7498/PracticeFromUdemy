package com.projects.demo.Services;

import com.projects.demo.Models.JobPost;
import com.projects.demo.Models.JobRating;
import com.projects.demo.Models.JobReponse;
import com.projects.demo.Repositories.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    public JobRepo jobrepo;


    // Creates a new Job
    public JobPost  saveAll(JobPost jobPost) {
        return jobrepo.save(jobPost);
    }

    // To fetch list of Jobs

    public List<JobPost> getAllJobs() {
        return jobrepo.findAll();

    }

    // Get a job
    public Optional<JobPost> getAJob(int jobPostID) {
        return jobrepo.findById(jobPostID);

    }



// Modifies by Patch method
//    public void ModifyAJob(JobPost jobPost) {
//        jobrepo.save(jobPost);
//    }

    //Replaces by Put method
    public void replaceAJob(JobPost jobPost) {
        jobrepo.save(jobPost);
    }

    //Deletes a job
    public void deleteAjob(int postID) {
        if (jobrepo.findById(postID).isPresent()){
        jobrepo.deleteById(postID);}
    }


    public void loadData() {
        List<JobPost> jobs = new ArrayList<>();

        jobs.add(new JobPost(
                1,
                "Java Developer",
                "Must have good experience in core Java and advanced Java",
                2,
                List.of("Core Java", "J2EE", "Spring Boot", "Hibernate"),
                new JobRating( 5,"Excellent team player")
        ));

        jobs.add(new JobPost(
                2,
                "Python Developer",
                "Strong knowledge in Python, Django and APIs",
                3,
                List.of("Python", "Django", "REST API"),
                new JobRating(4, "Very good problem solver")
        ));

        jobs.add(new JobPost(
                3,
                "Frontend Developer",
                "Experience with Angular or React",
                2,
                List.of("JavaScript", "React", "CSS"),
                new JobRating(3, "Good communication skills")
        ));

        // 🔹 This saves all JobPosts (and JobRatings because of CascadeType.ALL)
        jobrepo.saveAll(jobs);

    }
}
