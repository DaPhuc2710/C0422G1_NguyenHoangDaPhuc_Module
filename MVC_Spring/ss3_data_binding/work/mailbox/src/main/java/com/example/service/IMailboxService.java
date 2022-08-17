package com.example.service;

import com.example.model.Mailbox;

public interface IMailboxService {
    Mailbox findAll();

    void save(Mailbox mailbox);
}
