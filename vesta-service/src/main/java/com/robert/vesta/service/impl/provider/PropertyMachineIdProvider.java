package com.robert.vesta.service.impl.provider;

/**
 * 通过配置文件分配机器ID
 */
public class PropertyMachineIdProvider implements MachineIdProvider {
    private long machineId;

    @Override
    public long getMachineId() {
        return machineId;
    }

    public void setMachineId(long machineId) {
        this.machineId = machineId;
    }
}
