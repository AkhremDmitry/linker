package com.asuscomm.reisin.linker.controller;

import com.asuscomm.reisin.linker.model.Group;
import com.asuscomm.reisin.linker.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    /**
     * https://www.boraji.com/spring-mvc-4-hibernate-5-restful-crud-operations-example
     *
     *
     * */
    @PostMapping("/group")
    public ResponseEntity<?> save(@RequestBody Group group) {
        int id = groupService.save(group);
        return ResponseEntity.ok().body("New Group has been saved with ID:" + id);
    }

    @GetMapping("/groups")
    public ResponseEntity<List<Group>> list() {
        List<Group> groups = groupService.list();

        for (Group i:groups){
            System.out.println(i.toString());
        }
        return ResponseEntity.ok().body(groups);
    }

    @GetMapping("/group/{id}")
    public ResponseEntity<Group> get(@PathVariable("id") int id) {
        Group group = groupService.get(id);
        return ResponseEntity.ok().body(group);
    }

    @PutMapping("/group/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Group group) {
        groupService.update(id, group);
        return ResponseEntity.ok().body("Group has been updated successfully.");
    }

    @DeleteMapping("/group/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        groupService.delete(id);
        return ResponseEntity.ok().body("Group has been deleted successfully.");
    }

}
