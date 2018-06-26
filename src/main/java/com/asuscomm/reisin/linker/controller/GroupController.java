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



    /**
     * This method returns a list of {@code Group} objects.
     * It supports request
     * URLS like:<br/>
     *
     * <pre>
     * {@code
     * GET: /groups
     * }
     * </pre>
     *
     * <pre>
     * {@code
     *      [{"groupId":2,"groupName":null},
     *      {"groupId":3,"groupName":"Jenkins"},
     *      {"groupId":4,"groupName":"Rest Service"},
     *      {"groupId":5,"groupName":"Applications"},
     *      {"groupId":6,"groupName":"Network"},
     *      {"groupId":7,"groupName":"Databases"}]
     * }
     * </pre>
     *
     *
     *
     * @return List of Group object
     */

    @GetMapping("/groups")
    public ResponseEntity<List<Group>> list() {
        List<Group> groups = groupService.list();
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
