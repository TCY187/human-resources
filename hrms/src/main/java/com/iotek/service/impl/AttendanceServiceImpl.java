package com.iotek.service.impl;

import com.iotek.dao.AttendanceMapper;
import com.iotek.model.Attendance;
import com.iotek.service.AttendanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by TCY on 2018/8/3.
 */
@Service
public class AttendanceServiceImpl implements AttendanceService{
    @Resource
    private AttendanceMapper attendanceMapper;

    public boolean saveAttendance(Attendance attendance) {
        return attendanceMapper.saveAttendance(attendance);
    }

    public boolean updateAttendance(int aid) {
        return attendanceMapper.updateAttendance(aid);
    }

    public Attendance getAttendanceByEid(int eid) {
        return attendanceMapper.getAttendanceByEid(eid);
    }

    public boolean updateAttendanceNull(int aid) {
        return attendanceMapper.updateAttendanceNull(aid);
    }

    public List<Attendance> getAttendanceByEid1(int eid) {
        return attendanceMapper.getAttendanceByEid1(eid);
    }

    public List<Attendance> getAttendanceByEid1AndPage(int eid, int begin, int end) {
        return attendanceMapper.getAttendanceByEid1AndPage(eid, begin, end);
    }

    public List<Attendance> getAttendanceByEidLastMonth(int eid, int state) {
        return attendanceMapper.getAttendanceByEidLastMonth(eid, state);
    }
}
