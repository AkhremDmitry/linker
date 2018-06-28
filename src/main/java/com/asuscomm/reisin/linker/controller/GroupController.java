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
     * This method returns message if new group was created successfully
     * Request:
     * <pre>
     * {@code
     * POST: /save
     * }
     * </pre>
     * <pre>
     * {@code
     *  {
     *    "name": "newGroup",
     *   }
     * }
     * </pre>
     * @return String message
     */
    @PostMapping("/group")
    public ResponseEntity<?> save(@RequestBody Group group) {
        int id = groupService.save(group);
        return ResponseEntity.ok().body(id);
    }

    /**
     * This method returns a list of {@code Group} objects.
     * Request:
     * <pre>
     * {@code
     * GET: /groups
     * }
     * </pre>
     * <pre>
     * {@code
     *[
     *  {
     *    "id": 1,
     *    "name": "group1"
     *  },
     *  {
     *    "id": 2,
     *    "name": "group2",
     *  }
     *]
     * }
     * </pre>
     *
     * @return List of Group object
     */

    @GetMapping("/groups")
    public ResponseEntity<List<Group>> list() {
        List<Group> groups = groupService.list();
        return ResponseEntity.ok().body(groups);
    }

    /**
     * This method returns one {@code Group} object by id.
     * Request:
     * <pre>
     * {@code
     * GET: /group/{id}
     * }
     * </pre>
     * <pre>
     * {@code
     *  {
     *    "id": 1,
     *    "name": "Applications"
     *  }
     * }
     * </pre>
     * @return Group object
     */
    @GetMapping("/group/{id}")
    public ResponseEntity<Group> get(@PathVariable("id") int id) {
        Group group = groupService.get(id);
        return ResponseEntity.ok().body(group);
    }

    /**
     * This method returns message if group was updated by id successfully
     * Request:
     * <pre>
     * {@code
     * UPDATE: /group/{id}
     * }
     * </pre>
     * <pre>
     * {@code
     * {
     *    "name":"Applications"
     * }
     * </pre>
     * @return String message
     */
    @PutMapping("/group")
    public ResponseEntity<?> update(@RequestBody Group group) {
        groupService.update(group);
        return ResponseEntity.ok().body("Group has been updated successfully.");
    }

    /**
     * This method returns message if group was deleted by id successfully
     * Request:
     * <pre>
     * DELETE: /group/{id}
     * </pre>
     * @return String message
     */
    @DeleteMapping("/group/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        groupService.delete(id);
        return ResponseEntity.ok().body("Group has been deleted successfully.");
    }

}
