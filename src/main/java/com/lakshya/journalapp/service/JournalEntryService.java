package com.lakshya.journalapp.service;
import java.time.LocalDateTime;
import java.util.*;
import com.lakshya.journalapp.Entity.JournalEntry;
import com.lakshya.journalapp.Entity.User;
import com.lakshya.journalapp.Repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName){
        User user = userService.findByUserName(userName);
        if(user == null){
            throw new RuntimeException("User not found");
        }
        journalEntry.setDate(LocalDateTime.now());
        JournalEntry saved = journalEntryRepository.save(journalEntry); //save to database
        user.getJournalEntries().add(saved);//user pojo me journalEntries list me journalEntry ka data add krna
        userService.saveEntry(user);
    }


    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }


    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    @Transactional
    public void deleteById(ObjectId id, String userName) {
        User user = userService.findByUserName(userName);
        if(user == null){
            throw new RuntimeException("User not found");
        }
        user.getJournalEntries().removeIf(x -> x.getId().equals(id));
        userService.saveEntry(user);
        journalEntryRepository.deleteById(id);
    }
}
