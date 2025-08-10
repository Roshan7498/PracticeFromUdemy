package com.projects.demo.Repositories;

import com.projects.demo.Models.JobPost;
import com.projects.demo.Models.JobRating;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
  @Repository
public class JobRepo {

        // arrayList to store store JobPost objects
        List<JobPost> jobs = new ArrayList<>();

        // ****************************************************************************

        // constructor->injecting objects into ArrayList defined sabove.

       public JobRepo()
      {

        /*    // Java Developer Job Post
            jobs.add(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                    List.of("Core Java", "J2EE", "Spring Boot", "Hibernate"),new JobRating(1,"1xyz")));

            // Frontend Developer Job Post
            jobs.add(new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
                    3, List.of("HTML", "CSS", "JavaScript", "React"),new JobRating(2,"2xyz")));

            // Data Scientist Job Post
            jobs.add(new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                    List.of("Python", "Machine Learning", "Data Analysis"),new JobRating(3,"3xyz")));

            // Network Engineer Job Post
            jobs.add(new JobPost(4, "Network Engineer",
                    "Design and implement computer networks for efficient data communication", 5,
                    List.of("Networking", "Cisco", "Routing", "Switching"),new JobRating(4,"4xyz")));

            // Mobile App Developer Job Post
            jobs.add(new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
                    List.of("iOS Development", "Android Development", "Mobile App"),new JobRating(5,"5xyz"))); */
        }



        // method to return all JobPosts
        public List<JobPost> getAllJobs() {
            return jobs;
        }
       // Get a job
    public JobPost getAJob(int jobPostID) {

           for(JobPost jp : jobs){
            if(jp.getPostId()==jobPostID){

                return jp;
            }

        }
        return null;
    }

    //Creates new job/s
    public List<JobPost> saveAll(List<JobPost> jobPosts) {
        jobs.addAll(jobPosts);
        return jobs; // full list
    }


// Modifies by patch method
    public JobPost ModifyAJob(JobPost jobPost) {

            for(JobPost jobs1:jobs){
                if(jobs1.getPostId()== jobPost.getPostId()){
                   jobs1.setPostId(jobPost.getPostId());
jobs1.setPostDesc(jobPost.getPostDesc());
jobs1.setPostProfile(jobPost.getPostProfile());
jobs1.setReqExperience(jobPost.getReqExperience());
jobs1.setPostTechStack(jobPost.getPostTechStack());
jobs1.setJobRating(jobPost.getJobRating());

                }
                return  jobs1;
            }

return null;
    }

    // replaces by put method
    public JobPost replaceAJob(JobPost jobPost) {
        for(JobPost jobs1:jobs){
            if(jobs1.getPostId()== jobPost.getPostId()){
                jobs1.setPostId(jobPost.getPostId());
                jobs1.setPostDesc(jobPost.getPostDesc());
                jobs1.setPostProfile(jobPost.getPostProfile());
                jobs1.setReqExperience(jobPost.getReqExperience());
                jobs1.setPostTechStack(jobPost.getPostTechStack());
                jobs1.setJobRating(jobPost.getJobRating());

            }
         return jobs1;
        } return null;
    }
//     Deletes a Job

    public void deleteAjob(int postID) {
            for (JobPost jobs1:jobs){

                if ( jobs1.getPostId()==postID){

                    jobs.remove(jobs1);
                }

        }
    }


}

