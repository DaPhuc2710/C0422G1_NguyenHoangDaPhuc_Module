package com.example.service.impl;

import com.example.model.Mailbox;
import com.example.repository.IMailboxRepository;
import com.example.service.IMailboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailboxService implements IMailboxService {
    @Autowired
    private IMailboxRepository iMailboxRepository;

    @Override
    public Mailbox findAll() {
        return iMailboxRepository.findAll();
    }

    @Override
    public void save(Mailbox mailbox) {
        iMailboxRepository.save(mailbox);
    }
}
