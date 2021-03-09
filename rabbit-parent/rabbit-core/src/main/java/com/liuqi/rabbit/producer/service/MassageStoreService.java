package com.liuqi.rabbit.producer.service;

import com.liuqi.rabbit.common.contant.BrokerMessageStatus;
import com.liuqi.rabbit.producer.entity.BrokerMessage;
import com.liuqi.rabbit.producer.mapper.BrokerMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

;import java.util.Date;

/**
 *
 * @auther liuqi
 * @create 2021-03-05  16:37
 */

@Service
public class MassageStoreService {
    @Autowired
    private BrokerMessageMapper brokerMessageMapper;

    public void insertMassage(BrokerMessage brokerMessage){
         brokerMessageMapper.insert(brokerMessage);
    }

    public void success(String messageId) {
        brokerMessageMapper.changeBrokerMessageStatus(messageId, BrokerMessageStatus.SEND_OK.getCode(), new Date());
    }

    public void fail(String messageId) {
        brokerMessageMapper.changeBrokerMessageStatus(messageId, BrokerMessageStatus.SEND_FAIL.getCode(), new Date());

    }
}
