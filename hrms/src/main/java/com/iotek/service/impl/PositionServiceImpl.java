package com.iotek.service.impl;

import com.iotek.dao.PositionMapper;
import com.iotek.model.Position;
import com.iotek.service.PositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by TCY on 2018/7/27.
 */
@Service
public class PositionServiceImpl implements PositionService{
    @Resource
    private PositionMapper positionMapper;

    public boolean savePosition(Position position) {
        return positionMapper.savePosition(position);
    }

    public boolean deletePosition(int pid) {
        return positionMapper.deletePosition(pid);
    }

    public boolean updatePosition(Position position) {
        return positionMapper.updatePosition(position);
    }

    public boolean deletePositionByDid(int did) {
        return positionMapper.deletePositionByDid(did);
    }

    public List<Position> getPositionByDid(int did) {
        return positionMapper.getPositionByDid(did);
    }

    public List<Position> getPositionByDidAndPage(int did, int begin, int end) {
        return positionMapper.getPositionByDidAndPage(did, begin, end);
    }
}
