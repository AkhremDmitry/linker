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

    @PostMapping("/link")
    public ResponseEntity<?> save(@RequestBody Link link) {
        int id = linkService.save(link);
        return ResponseEntity.ok().body("New link has been saved with ID:" + id);
    }

    /**
     * This method returns a list of {@code Link} objects.
     * It supports request
     * URLS like:<br/>
     * <pre>
     * {@code
     * GET: /links
     * }
     * </pre>
     *
     * <pre>
     * {@code
     *
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

    @GetMapping("/link/{id}")
    public ResponseEntity<Link> get(@PathVariable("id") int id) {
        Link link = linkService.get(id);
        return ResponseEntity.ok().body(link);
    }

    @PutMapping("/link/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Link link) {
        linkService.update(id, link);
        return ResponseEntity.ok().body("Link has been updated successfully.");
    }

    @DeleteMapping("/link/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        linkService.delete(id);
        return ResponseEntity.ok().body("Link has been deleted successfully.");
    }


}
