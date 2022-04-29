package com.example.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jrojas
 */
@Configuration
public class RabbitMqConfig {

    public static final String QUEUE = "test_queue";
    public static final String EXCHANGE = "test_exchange";
    public static final String ROUTING_KEY = "test_routing_key";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(ROUTING_KEY);
    }
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

    public static final String QUEUE2 = "test_queue2";
    public static final String EXCHANGE2 = "test_exchange2";
    public static final String ROUTING_KEY2 = "test_routing_key2";

    @Bean
    public Queue queue2() {
        return new Queue(QUEUE2);
    }

    @Bean
    public DirectExchange exchange2() {
        return new DirectExchange(EXCHANGE2);
    }

    @Bean
    public Binding binding2(Queue queue2, DirectExchange exchange2) {
        return BindingBuilder
                .bind(queue2)
                .to(exchange2)
                .with(ROUTING_KEY2);
    }

    @Bean
    public MessageConverter messageConverter2() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template2(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate2 = new RabbitTemplate(connectionFactory);
        rabbitTemplate2.setMessageConverter(messageConverter2());
        return rabbitTemplate2;
    }

    public static final String QUEUE3 = "test_queue3";
    public static final String EXCHANGE3 = "test_exchange3";
    public static final String ROUTING_KEY3 = "test_routing_key3";

    @Bean
    public Queue queue3() {
        return new Queue(QUEUE3);
    }

    @Bean
    public FanoutExchange exchange3() {
        return new FanoutExchange(EXCHANGE3);
    }

    @Bean
    public Binding binding3(Queue queue3, FanoutExchange exchange3) {
        return BindingBuilder
                .bind(queue3)
                .to(exchange3);
    }

    @Bean
    public MessageConverter messageConverter3() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template3(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate3 = new RabbitTemplate(connectionFactory);
        rabbitTemplate3.setMessageConverter(messageConverter3());
        return rabbitTemplate3;
    }


}
