package com.iotek.service.impl;

import com.iotek.dao.DepaMapper;
import com.iotek.model.Depa;
import com.iotek.service.DepaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by TCY on 2018/7/27.
 */
@Service
public class DepaServiceImpl implements DepaService{
    @Resource
    private DepaMapper depaMapper;

    public boolean deleteDepa(int id) {
        return depaMapper.deleteDepa(id);
    }

    public boolean updateDepa(Depa depa) {
        return depaMapper.updateDepa(depa);
    }

    public boolean saveDepa(Depa depa) {
        return depaMapper.saveDepa(depa);
    }

    public List<Depa> getAllDepa() {
        return depaMapper.getAllDepa();
    }

    public Depa getDepaByDid(int did) {
        return depaMapper.getDepaByDid(did);
    }

    public List<Depa> getAllDepaByPage(int begin, int end) {
        return depaMapper.getAllDepaByPage(begin, end);
    }

}
