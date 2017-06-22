package edu.mum.coffee.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Hatake on 6/21/2017.
 */
public class OrderDTO {

    private Date orderDate;
    private long personId;

    private List<OrderLineDTO> orderLinesDTO = new ArrayList<>();

    public List<OrderLineDTO> getOrderLinesDTO() {
        return orderLinesDTO;
    }

    public void setOrderLinesDTO(List<OrderLineDTO> orderLinesDTO) {
        this.orderLinesDTO = orderLinesDTO;
    }


    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }
}
