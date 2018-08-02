package com.iotek.dao;

import com.iotek.model.Position;

import java.util.List;

/**
 * Created by TCY on 2018/7/27.
 */
public interface PositionMapper {
    boolean savePosition(Position position);
    boolean deletePosition(int pid);
    boolean updatePosition(Position position);
    boolean deletePositionByDid(int did);
    List<Position> getPositionByDid(int did);
    List<Position> getPositionByDidAndPage(int did,int begin,int end);
}
