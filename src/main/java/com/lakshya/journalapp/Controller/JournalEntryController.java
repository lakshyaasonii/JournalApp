package com.lakshya.journalapp.Controller;

import com.lakshya.journalapp.Entity.JournalEntry;
import com.lakshya.journalapp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    @PostMapping
    public ResponseEntity<?> createEntry(@RequestBody JournalEntry myEntry){
        myEntry.setDate(LocalDateTime.now()); //date and time
        journalEntryService.saveEntry(myEntry);
        return new ResponseEntity<>(myEntry,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<JournalEntry> list = journalEntryService.getAll();
        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getjournalEntryById(@PathVariable ObjectId id){
        Optional<JournalEntry> journalEntry = journalEntryService.findById(id);
        if (journalEntry.isPresent()) {
            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable ObjectId id){
       Optional<JournalEntry> journalEntry = journalEntryService.findById(id);
       if(journalEntry.isPresent()){
           journalEntryService.deleteById(id);
           return new ResponseEntity<>(HttpStatus.OK);
       }
       else{
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }

    @PutMapping("id/{id}")
    public ResponseEntity<?> update(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry){
        Optional<JournalEntry> oldEntry = journalEntryService.findById(id);
        if(oldEntry.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            JournalEntry oldEntryData = oldEntry.get();
            oldEntryData.setTitle(newEntry.getTitle());
            oldEntryData.setContent(newEntry.getContent());
            //ab updated data ko save bhi krna padega
            journalEntryService.saveEntry(oldEntryData);
            return new ResponseEntity<>(oldEntryData,HttpStatus.OK);
        }
    }
}
