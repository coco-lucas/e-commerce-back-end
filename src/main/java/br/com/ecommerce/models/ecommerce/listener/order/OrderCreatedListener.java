package br.com.ecommerce.models.ecommerce.listener.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;

import br.com.ecommerce.models.ecommerce.config.RabbitMqConfig;
import br.com.ecommerce.models.ecommerce.listener.order.dto.OrderCreatedEvent;
import br.com.ecommerce.models.ecommerce.service.order.CreateOrderService;

//consumindo a fila do RabbitMQ
public class OrderCreatedListener {
    private final Logger logger = LoggerFactory.getLogger(OrderCreatedListener.class);
    private final CreateOrderService orderService;

    public OrderCreatedListener(CreateOrderService orderService) {
        this.orderService = orderService;
    }

    @RabbitListener(queues = RabbitMqConfig.ORDER_CREATED_QUEUE)
    public void listen(Message<OrderCreatedEvent> message) {
        logger.info("Message consumed: {}", message);

        orderService.save(message.getPayload());
    }
}
