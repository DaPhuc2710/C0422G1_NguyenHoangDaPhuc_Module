package com.example.repository;

import com.example.model.Mailbox;

import java.util.List;

public interface IMailboxRepository {
    List<Mailbox> findAll();
}
