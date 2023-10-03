package com.assignment.api;

import com.assignment.request.order.NewOrderReq;
import com.assignment.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService service;

    @Test
    void CreateOrder() throws Exception {
        NewOrderReq orderReq = new NewOrderReq();
        orderReq.setAddress("test");
        orderReq.setQueueId(1);
        orderReq.setCustomerName("customer_test");
        orderReq.setShopId(1);
        when(service.createOrder(orderReq)).thenReturn("Success");
            this.mockMvc.perform(post("/create",orderReq)).andDo(print()).andExpect(status().isOk())
                    .andExpect(content().string(containsString("Success")));
    }
}
