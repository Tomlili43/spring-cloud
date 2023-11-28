package com.dailycodebuffer.departmentservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.dailycodebuffer.departmentservice.controller.OrderController;
import com.dailycodebuffer.departmentservice.model.Order;
import com.dailycodebuffer.departmentservice.service.OrderService;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
public class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Test
    public void createOrderTest() throws Exception {
        Order order = new Order();
        order.setCustomerName("John Doe");
        order.setProduct("Laptop");
        order.setStatus("ACCEPTED");

        when(orderService.createOrder(order)).thenReturn(order);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/department/order")
                .content("{\"customerName\":\"John Doe\",\"product\":\"Laptop\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
