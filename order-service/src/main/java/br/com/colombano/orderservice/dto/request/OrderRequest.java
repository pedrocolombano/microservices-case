package br.com.colombano.orderservice.dto.request;

public record OrderRequest(
        Long productId,
        Integer quantity
) {
}
