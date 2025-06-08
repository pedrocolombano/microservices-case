package br.com.colombano.orderservice.service;

import br.com.colombano.orderservice.dto.request.OrderRequest;
import br.com.colombano.orderservice.entity.Order;
import br.com.colombano.orderservice.entity.enumerated.OrderStatus;
import br.com.colombano.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();

        order.setProductId(orderRequest.productId());
        order.setQuantity(orderRequest.quantity());
        order.setOrderStatus(OrderStatus.PENDING);

        orderRepository.save(order);

        log.info("Order {} placed successfully", order.getId());
    }

}
