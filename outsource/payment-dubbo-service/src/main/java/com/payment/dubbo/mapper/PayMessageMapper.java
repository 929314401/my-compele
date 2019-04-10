package com.payment.dubbo.mapper;

import com.payment.dubbo.dto.PayMessage;
import com.payment.dubbo.dto.PayMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayMessageMapper {
    int countByExample(PayMessageExample example);

    int deleteByExample(PayMessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayMessage record);

    int insertSelective(PayMessage record);

    List<PayMessage> selectByExample(PayMessageExample example);

    PayMessage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayMessage record, @Param("example") PayMessageExample example);

    int updateByExample(@Param("record") PayMessage record, @Param("example") PayMessageExample example);

    int updateByPrimaryKeySelective(PayMessage record);

    int updateByPrimaryKey(PayMessage record);
}