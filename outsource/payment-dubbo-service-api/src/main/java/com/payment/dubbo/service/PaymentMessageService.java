package com.payment.dubbo.service;

import com.payment.dubbo.dto.PayMessage;

import java.util.List;

public interface PaymentMessageService {
    List<PayMessage> selectByPid(Integer id,Integer page,Integer rows);
    PayMessage selectByid(Integer id);
    void insertPayMessage(PayMessage payMessage);


}
