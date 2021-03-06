package com.kerimfettahoglu.issuemanagementkerim.api;

import com.kerimfettahoglu.issuemanagementkerim.dto.ProjectDto;
import com.kerimfettahoglu.issuemanagementkerim.entity.Project;
import com.kerimfettahoglu.issuemanagementkerim.service.impl.ProjectServiceImpl;
import com.kerimfettahoglu.issuemanagementkerim.util.TPage;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/project")
@CrossOrigin
public class ProjectController {

    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }

    @GetMapping()
    @RequestMapping("/get/{id}")
    public ResponseEntity<ProjectDto> getProject(@PathVariable("id") Long id) {
        return ResponseEntity.ok(projectServiceImpl.getAProject(id));
    }

    @PostMapping()
    @RequestMapping("/post")
    public ResponseEntity<ProjectDto> saveProject(@RequestBody ProjectDto projectDto) {
        return ResponseEntity.ok(projectServiceImpl.save(projectDto));
    }

    @PutMapping
    @RequestMapping("/put")
    public ResponseEntity<ProjectDto> updateProject(@RequestBody ProjectDto projectDto) {
        return ResponseEntity.ok(projectServiceImpl.updateProject(projectDto));
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteProject(@PathVariable Long id) {
        boolean result = projectServiceImpl.delete(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    @RequestMapping("/getAll")
    public ResponseEntity<TPage<ProjectDto>> getAll(Pageable pageable) {
        TPage<ProjectDto> data = projectServiceImpl.getAll(pageable);
        return ResponseEntity.ok(data);
    }
}