package com.asuscomm.reisin.linker.config;

import com.asuscomm.reisin.linker.model.Group;
import com.asuscomm.reisin.linker.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    /*---Add new group---*/
    @PostMapping("/group")
    public ResponseEntity<?> save(@RequestBody Group group) {
        int id = groupService.save(group);
        return ResponseEntity.ok().body("New Group has been saved with ID:" + id);
    }

}
