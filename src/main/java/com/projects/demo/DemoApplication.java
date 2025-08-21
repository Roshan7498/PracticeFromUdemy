package com.projects.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}



/*
To be added in README
✅ Steps to Customize Swagger UI



1. Add @Tag at Controller level
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@Tag(name = "Job Management", description = "APIs for managing job posts")
public class JobRestController {


👉 This changes job-rest-controller to Job Management in Swagger UI.

2. Add @Operation for endpoints
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.Parameter;

@GetMapping("/jobPosts")
@Operation(summary = "Fetch all jobs", description = "Returns a list of all job posts available in the system")
public List<JobPost> getAllJobs() {
    return jobservice.getAllJobs();
}


Example for GET by ID:

@GetMapping("/jobPosts/{jobPostID}")
@Operation(summary = "Fetch a job by ID", description = "Retrieve details of a specific job post using its ID")
public Optional<JobPost> getAJob(@Parameter(description = "ID of the job to retrieve")
                                 @PathVariable("jobPostID") int jobPostID) {
    return jobservice.getAJob(jobPostID);
}

3. Add @ApiResponse for response documentation
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@PostMapping("/jobPosts")
@Operation(summary = "Create a new job post", description = "Add a new job post to the system")
@ApiResponse(responseCode = "200", description = "Job created successfully")
@ApiResponse(responseCode = "400", description = "Invalid input provided")
public JobPost createJobs(@org.springframework.web.bind.annotation.RequestBody JobPost jobPost) {
    return jobservice.saveAll(jobPost);
}

4. Add Global Info (API title, version, description)

Create a class with @OpenAPIDefinition:

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Job API",
        version = "1.0",
        description = "This API allows CRUD operations on job posts"
    )
)
public class OpenApiConfig {
}

🔥 Result

After these changes:

The top title will be Job API (v1.0).

The section will be Job Management (instead of job-rest-controller).

Each endpoint will have a summary + description.

Swagger UI will look like a professional API spec.

 */