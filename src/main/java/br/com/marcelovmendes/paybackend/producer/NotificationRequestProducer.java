package br.com.marcelovmendes.paybackend.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.marcelovmendes.paybackend.model.Transaction;

@Component
public class NotificationRequestProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(Transaction transaction) {
        amqpTemplate.convertAndSend("notification-request-exchange", "notification-routing-key", transaction);
    }
}