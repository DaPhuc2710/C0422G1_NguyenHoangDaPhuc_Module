package com.example.repository.impl;

import com.example.model.Mailbox;
import com.example.repository.IMailboxRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MailboxRepository implements IMailboxRepository {
    private Mailbox mailbox1;

    @Override
    public Mailbox findAll() {
        return mailbox1;
    }

    @Override
    public void save(Mailbox mailbox) {
        mailbox1 = mailbox;
    }
}
