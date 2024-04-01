package br.com.marcelovmendes.paybackend.service;

import org.springframework.stereotype.Service;

import br.com.marcelovmendes.paybackend.model.Transaction;
import br.com.marcelovmendes.paybackend.producer.NotificationRequestProducer;

@Service
public class NotificationService {

    private NotificationRequestProducer notificationRequestProducer;

    public NotificationService(NotificationRequestProducer notificationRequestProducer) {
        this.notificationRequestProducer = notificationRequestProducer;
    }

    public void notify(Transaction requeTransaction) {
        notificationRequestProducer.send(requeTransaction);

    }

}
