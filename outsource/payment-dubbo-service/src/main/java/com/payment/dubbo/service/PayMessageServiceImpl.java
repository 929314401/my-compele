package com.payment.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.payment.dubbo.dto.PageBean;
import com.payment.dubbo.dto.PayMessage;
import com.payment.dubbo.dto.PayMessageExample;
import com.payment.dubbo.mapper.PayMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PayMessageServiceImpl implements PaymentMessageService {
    @Autowired
    private PayMessageMapper payMessageMapper;
    @Override
    public List<PayMessage> selectByPid(Integer id, Integer page, Integer rows) {
        PayMessageExample payMessageExample = new PayMessageExample();
        PayMessageExample.Criteria criteria = payMessageExample.createCriteria();
        criteria.andPidEqualTo(id);
        List<PayMessage> list = payMessageMapper.selectByExample(payMessageExample);

        return pageMain(list,page,rows);
    }

    @Override
    public PayMessage selectByid(Integer id) {

        return payMessageMapper.selectByPrimaryKey(id);
    }

    @Override
    public void insertPayMessage(PayMessage payMessage) {
        payMessageMapper.insert(payMessage);
    }

    List<PayMessage> pageMain(List<PayMessage> list,Integer page,Integer rows){
        PageHelper.startPage(page,rows);
        int size =list.size();//总数
        PageBean<PayMessage> pageInfo=new PageBean<>(page,rows,size);
        pageInfo.setItems(list);
        return pageInfo.getItems();
    }
}
