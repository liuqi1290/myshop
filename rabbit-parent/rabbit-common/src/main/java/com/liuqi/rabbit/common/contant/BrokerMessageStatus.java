package com.liuqi.rabbit.common.contant;

public enum BrokerMessageStatus {
    SENDING("0"),
    SEND_OK("1"),
    SEND_FAIL("2"),
    SEND_FAIL_AMOUMENT("2");

    private String code;

    BrokerMessageStatus(String code) {
        this.code=code;
    }

    public String getCode() {
        return code;
    }
}
