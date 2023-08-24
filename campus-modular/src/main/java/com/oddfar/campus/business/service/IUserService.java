package com.oddfar.campus.business.service;

import com.alibaba.fastjson2.JSONObject;
import com.oddfar.campus.business.entity.IUser;
import com.oddfar.campus.common.domain.PageResult;

import java.util.List;

public interface IUserService {

    PageResult<IUser> page(IUser iUser);

    /**
     * 添加i茅台用户
     *
     * @param mobile
     * @param body
     * @return
     */
    int insertIUser(Long mobile, String deviceId, JSONObject body);

    /**
     * 查询预约用户列表
     *
     * @return
     */
    List<IUser> selectReservationUser();

    /**
     * 通过预约执行分钟查询预约用户列表
     *
     * @return
     */
    List<IUser> selectReservationUserByMinute(int minute);

    /**
     * 添加i茅台用户
     *
     * @param iUser
     * @return
     */
    int insertIUser(IUser iUser);

    /**
     * 修改I茅台用户
     *
     * @param iUser I茅台用户
     * @return 结果
     */
    int updateIUser(IUser iUser);

    /**
     * 批量修改用户随机预约的时间
     *
     * @return
     */
    void updateUserMinuteBatch();

    /**
     * 删除用户
     *
     * @param iUserId id
     * @return
     */
    int deleteIUser(Long[] iUserId);


    /***
     * 批量修改用户今日预约状态
     */
    void updateUserAppointmentStatusBatch();

    /***
     * 更新用户的预约状态
     * @param mobile 用户手机号
     * @param appointmentStatus 今日预约状态（0：未预约，1:预约成功，2:预约失败）
     */
    void updateUserAppointmentStatus(Long mobile,Integer appointmentStatus);
}
