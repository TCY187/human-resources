package com.iotek.dao;

import com.iotek.model.Cul;

import java.util.Date;
import java.util.List;

/**
 * Created by TCY on 2018/8/2.
 */
public interface CulMapper {
    List<Cul> getCulByState(int state);
    List<Cul> getCulByStateAndPage(int state,int begin,int end);
    boolean saveCul(Cul cul);
    boolean updateCulStateByCid(int state, Date issuetime, int cid);
    Cul getCulByCid(int cid);
    boolean deleteCulByCid(int cid);
    boolean updateCulByCid(Cul cul);
}
