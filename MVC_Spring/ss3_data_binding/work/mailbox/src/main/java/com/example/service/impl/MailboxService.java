package com.example.service.impl;

import com.example.model.Mailbox;
import com.example.repository.IMailboxRepository;
import com.example.service.IMailboxService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MailboxService implements IMailboxService {
    @Autowired
    private IMailboxRepository iMailboxRepository;

    @Override
    public List<Mailbox> findAll() {
        return iMailboxRepository.findAll();
    }
}
