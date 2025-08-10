package com.projects.demo.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class JobReponse {

        private int count;
        private List<JobPost> jobs;

//        public JobResponse(int count, List<JobPost> jobs) {
//            this.count = count;
//            this.jobs = jobs;
//        }
//
//        public int getCount() {
//            return count;
//        }
//
//        public List<JobPost> getJobs() {
//            return jobs;
//        }
    }

