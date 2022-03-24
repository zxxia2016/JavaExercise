package com.zxxia.s55_factorypattern;

public class ComputerFactory {
    static Computer createComputer(String name) {
        switch (name) {
            case "huawei": {
                Computer c = new HUAWEI();
                c.setName("huawie");
                c.setPrize(5000);
                return c;
            }
            case "mac": {
                Computer c = new Mac();
                c.setName("mac");
                c.setPrize(15000);
                return c;
            }
            default:
                return null;
        }
    }
}
