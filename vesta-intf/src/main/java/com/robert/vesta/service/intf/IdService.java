package com.robert.vesta.service.intf;

import com.robert.vesta.service.bean.Id;

import java.util.Date;

public interface IdService {

    /**
     * 获取ID
     * @return
     */
    public long genId();

    /**
     * 解析ID
     * @param id
     * @return
     */
    public Id expId(long id);

    /**
     * 制造ID
     * @param time
     * @param seq
     * @return
     */
    public long makeId(long time, long seq);

    /**
     * 制造ID
     * @param time
     * @param seq
     * @param machine
     * @return
     */
    public long makeId(long time, long seq, long machine);

    /**
     * 制造ID
     * @param genMethod
     * @param time
     * @param seq
     * @param machine
     * @return
     */
    public long makeId(long genMethod, long time, long seq, long machine);

    /**
     * 制造ID
     * @param type
     * @param genMethod
     * @param time
     * @param seq
     * @param machine
     * @return
     */
    public long makeId(long type, long genMethod, long time,
                       long seq, long machine);

    /**
     * 制造ID
     * @param version
     * @param type
     * @param genMethod
     * @param time
     * @param seq
     * @param machine
     * @return
     */
    public long makeId(long version, long type, long genMethod,
                       long time, long seq, long machine);

    /**
     * 时间戳格式化
     * @param time
     * @return
     */
    public Date transTime(long time);
}
