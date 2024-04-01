package br.com.marcelovmendes.paybackend.consumer;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.marcelovmendes.paybackend.model.Transaction;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.core.Queue;

@Component
public class NotificationConsumer {

    private AmqpAdmin amqpAdmin;

    public NotificationConsumer(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    @PostConstruct
    public void setup() {
        Queue queue = new Queue("notification-queue");
        TopicExchange exchange = new TopicExchange("notification-request-exchange");
        Binding binding = BindingBuilder.bind(queue).to(exchange).with("notification-routing-key");

        amqpAdmin.declareQueue(queue);
        amqpAdmin.declareExchange(exchange);
        amqpAdmin.declareBinding(binding);
    }

    @RabbitListener(queues = "notification-queue")
    public void consumeNotification(Transaction transaction) {
        // process the transaction
    }
}