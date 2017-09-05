package com.pandawork.home.service.system.impl;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.home.common.entity.system.Allot;
import com.pandawork.home.common.exception.ChException;
import com.pandawork.home.mapper.system.AllotMapper;
import com.pandawork.home.service.system.AllotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/5.
 */
@Service(value = "allotService")
public class AllotServiceImpl implements AllotService {
    @Autowired
    AllotMapper allotMapper;

    @Override
    public void addAllot(Allot allot) throws SSException {
        try{
            if (Assert.isNull(allot)){
                return;
            }
            allotMapper.addAllot(allot);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.AddAllotFailed);
        }
    }

    @Override
    public void updateAllot(Allot allot) throws SSException {
        try {
            if (Assert.isNull(allot)){
                return;
            }
            allotMapper.updateAllot(allot);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.UpdateAllotFailed);
        }
    }

    @Override
    public List<Allot> queryByUid(int uid) throws SSException {
        try{
            if (Assert.isNull(uid)){
                return null;
            }
            return allotMapper.queryByUid(uid);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryAllotByUidFailed);
        }
    }

    @Override
    public boolean delAllot(int id) throws SSException {
        try{
            if (Assert.isNull(id)){
                return false;
            }
            return allotMapper.delAllot(id);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.DelAllotFailed);
        }
    }

    @Override
    public List<Allot> listAll() throws SSException {
        try{
            return allotMapper.listAll();
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.ListAllAllotFailed);
        }
    }

    @Override
    public int countAll() throws SSException {
        try{
            return allotMapper.countAll();
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.CountAllAllotFailed);
        }
    }
}
