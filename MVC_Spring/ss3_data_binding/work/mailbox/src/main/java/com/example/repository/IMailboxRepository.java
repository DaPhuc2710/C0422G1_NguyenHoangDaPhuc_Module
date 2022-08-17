package com.example.repository;

import com.example.model.Mailbox;

public interface IMailboxRepository {
    Mailbox findAll();

    void save(Mailbox mailbox);
}
