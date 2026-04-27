package com.lakshya.journalapp.Repository;

import com.lakshya.journalapp.Entity.JournalEntry;
import com.lakshya.journalapp.Entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByUserName(String username);
}
