package com.nttdata;

public class OrderID {

    private static String orderId;

    public static void setOrderId(String id) {
        orderId = id;
    }

    public static String getOrderId() {
        return orderId;
    }
}
