package com.example.repository.impl;

import com.example.model.Mailbox;
import com.example.repository.IMailboxRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MailboxRepository implements IMailboxRepository {

    @Override
    public List<Mailbox> findAll() {
        return null;
    }
}
