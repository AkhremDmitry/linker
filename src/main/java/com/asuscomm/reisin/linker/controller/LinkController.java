package com.asuscomm.reisin.linker.controller;

import com.asuscomm.reisin.linker.model.Link;
import com.asuscomm.reisin.linker.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LinkController {

    @Autowired
    private LinkService linkService;

    /**
     * This method returns message if new link was created successfully
     * Request:
     * <pre>
     * {@code
     * POST: /save
     * }
     * </pre>
     * <pre>
     * {@code
     *  {
     *    "name": "testlink",
     *    "groupId": "6",
     *    "url": "http://address.com",
     *    "port": 8888,
     *    "description": "it's test link"
     *   }
     * }
     * </pre>
     * @return String message
     */
    @PostMapping("/link")
    public ResponseEntity<?> save(@RequestBody Link link) {
        int id = linkService.save(link);
        return ResponseEntity.ok().body("New link has been saved with ID:" + id);
    }

    /**
     * This method returns a list of {@code Link} objects.
     * Request:
     * <pre>
     * {@code
     * GET: /links
     * }
     * </pre>
     * <pre>
     * {@code
     * [
     *  {
     *    "id": 1,
     *    "name": "testlink",
     *    "groupId": "6",
     *    "url": "http://address.com",
     *    "port": 8888,
     *    "description": "it's test link"
     *  },
     *  {
     *    "id": 2,
     *    "name": "testlink2",
     *    "groupId": "9",
     *    "url": "http://address2.com",
     *    "port": 8888,
     *    "description": "it's test link2"
     *  }
     * ]
     * }
     * </pre>
     *
     * @return List of Link object
     */
    @GetMapping("/links")
    public ResponseEntity<List<Link>> list() {
        List<Link> links = linkService.list();
        return ResponseEntity.ok().body(links);
    }

    /**
     * This method returns one {@code Link} object by id.
     * Request:
     * <pre>
     * {@code
     * GET: /link/{id}
     * }
     * </pre>
     * <pre>
     * {@code
     *  {
     *    "id": 1,
     *    "name": "testlink",
     *    "groupId": "6",
     *    "url": "http://address.com",
     *    "port": 8888,
     *    "description": "it's test link"
     *  }
     * }
     * </pre>
     * @return Link object
     */
    @GetMapping("/link/{id}")
    public ResponseEntity<Link> get(@PathVariable("id") int id) {
        Link link = linkService.get(id);
        return ResponseEntity.ok().body(link);
    }

    /**
     * This method returns message if link was updated by id successfully
     * Request:
     * <pre>
     * {@code
     * UPDATE: /link/{id}
     * }
     * </pre>
     * <pre>
     * {@code
     *  {
     *    "name": "testlink",
     *    "groupId": "6",
     *    "url": "http://address.com",
     *    "port": 8888,
     *    "description": "it's test link"
     *   }
     * }
     * </pre>
     * @return String message
     */
    @PutMapping("/link/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Link link) {
        linkService.update(id, link);
        return ResponseEntity.ok().body("Link has been updated successfully.");
    }

    /**
     * This method returns message if link was deleted by id successfully
     * Request:
     * <pre>
     * DELETE: /link/{id}
     * </pre>
     * @return String message
     */
    @DeleteMapping("/link/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        linkService.delete(id);
        return ResponseEntity.ok().body("Link has been deleted successfully.");
    }


}
