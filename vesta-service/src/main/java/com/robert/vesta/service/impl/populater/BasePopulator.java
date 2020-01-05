package com.robert.vesta.service.impl.populater;

import com.robert.vesta.service.bean.Id;
import com.robert.vesta.service.impl.bean.IdMeta;
import com.robert.vesta.service.impl.bean.IdType;
import com.robert.vesta.util.TimeUtils;

public abstract class BasePopulator implements IdPopulator, ResetPopulator {
    protected long sequence = 0;
    protected long lastTimestamp = -1;

    public BasePopulator() {
        super();
    }

    /**
     * 首先查看当前时间是否已经到了下一个时间单位，如果已经到了则将序号清零
     * 如果还在上一个时间单位，就对序号进行累加
     * 如果累加越界，就等待下一时间单位产生唯一ID
     * @param id
     * @param idMeta
     */
    @Override
    public void populateId(Id id, IdMeta idMeta) {
        long timestamp = TimeUtils.genTime(IdType.parse(id.getType()));
        TimeUtils.validateTimestamp(lastTimestamp, timestamp);

        if (timestamp == lastTimestamp) {
            sequence++;
            sequence &= idMeta.getSeqBitsMask();
            if (sequence == 0) {
                timestamp = TimeUtils.tillNextTimeUnit(lastTimestamp, IdType.parse(id.getType()));
            }
        } else {
            lastTimestamp = timestamp;
            sequence = 0;
        }

        id.setSeq(sequence);
        id.setTime(timestamp);
    }

    @Override
    public void reset() {
        this.sequence = 0;
        this.lastTimestamp = -1;
    }
}
