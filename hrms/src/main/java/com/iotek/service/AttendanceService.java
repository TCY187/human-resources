package com.iotek.service;

import com.iotek.model.Attendance;

import java.util.List;

/**
 * Created by TCY on 2018/8/3.
 */
public interface AttendanceService {
    boolean saveAttendance(Attendance attendance);
    boolean updateAttendance(int aid);
    Attendance getAttendanceByEid(int eid);
    boolean updateAttendanceNull(int aid);
    List<Attendance> getAttendanceByEid1(int eid);
    List<Attendance> getAttendanceByEid1AndPage(int eid,int begin,int end);
    List<Attendance> getAttendanceByEidLastMonth(int eid,int state);//�ҳ����µ�
    List<Attendance> getAttenByEid(int eid);//����ĳԱ����ȫ��
    List<Attendance> getAttenByEidAndPage(int eid,int begin,int end);
}
