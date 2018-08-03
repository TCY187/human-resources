package com.iotek.dao;

import com.iotek.model.Attendance;

import java.util.List;

/**
 * Created by TCY on 2018/8/3.
 */
public interface AttendanceMapper {
    boolean saveAttendance(Attendance attendance);
    boolean updateAttendance(int aid);//�°��
    Attendance getAttendanceByEid(int eid);//�ҳ������
    boolean updateAttendanceNull(int aid);//������Сʱ��Ϊ����
    List<Attendance> getAttendanceByEid1(int eid);//�ҳ�ȫ��
    List<Attendance> getAttendanceByEid1AndPage(int eid,int begin,int end);//�ҳ�ȫ������ҳ
}