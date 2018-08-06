package com.iotek.dao;

import com.iotek.model.Attendance;

import java.util.List;

/**
 * Created by TCY on 2018/8/3.
 */
public interface AttendanceMapper {
    boolean saveAttendance(Attendance attendance);
    boolean updateAttendance(int aid);//下班打卡
    Attendance getAttendanceByEid(int eid);//找出当天的
    boolean updateAttendanceNull(int aid);//超过三小时变为旷工
    List<Attendance> getAttendanceByEid1(int eid);//找出当月的
    List<Attendance> getAttendanceByEid1AndPage(int eid,int begin,int end);//找出全部并分页
    List<Attendance> getAttendanceByEidLastMonth(int eid,int state);//找出上月的
    List<Attendance> getAttenByEid(int eid);//查找某员工的全部
    List<Attendance> getAttenByEidAndPage(int eid,int begin,int end);

}
