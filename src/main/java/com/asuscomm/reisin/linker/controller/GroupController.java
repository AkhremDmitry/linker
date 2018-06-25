package com.asuscomm.reisin.linker.controller;

import com.asuscomm.reisin.linker.model.Group;
import com.asuscomm.reisin.linker.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Group group) {
        int id = groupService.save(group);
        return ResponseEntity.ok().body("New Group has been saved with ID:" + id);
    }

    @GetMapping("/groups")
    public ResponseEntity<List<Group>> list() {
        List<Group> groups = groupService.list();
        return ResponseEntity.ok().body(groups);
    }

    @GetMapping("/")
    public ResponseEntity<String> hi() {
        return ResponseEntity.ok().body("HI");
    }


}
