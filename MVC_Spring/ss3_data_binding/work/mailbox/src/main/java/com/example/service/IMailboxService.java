package com.example.service;

import com.example.model.Mailbox;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMailboxService {
    List<Mailbox> findAll();
}
