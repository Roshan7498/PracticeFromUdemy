package com.projects.demo.repositories;

import com.projects.demo.models.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {






  }






      /*
       public JobRepo()
      {

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
    */




