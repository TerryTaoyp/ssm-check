package com.pandawork.home.service.check.impl;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.home.common.entity.check.JoinTest;
import com.pandawork.home.common.exception.ChException;
import com.pandawork.home.mapper.check.JoinTestMapper;
import com.pandawork.home.service.check.JoinTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/12.
 */
@Service(value = "joinTestService")
public class JoinTestServiceImpl implements JoinTestService{
    @Autowired
    JoinTestMapper joinTestMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void addCheck(JoinTest joinTest) throws SSException {
        try {
            if (Assert.isNull(joinTest)){
                return;
            }
            joinTestMapper.addCheck(joinTest);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.AddCheckFailed);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public boolean delById(int id) throws SSException {
        try {
            if (Assert.isNull(id)){
                return false;
            }
            return joinTestMapper.delById(id);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.DelCheckByIdFailed);
        }
    }

    @Override
    public JoinTest queryById(int id) throws SSException {
        try {
            if (Assert.isNull(id)){
                return null;
            }
            return joinTestMapper.queryById(id);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryJoinTestById);
        }
    }

    @Override
    public List<JoinTest> queryByUid(int uid) throws SSException {
        try {
            if (Assert.isNull(uid)) {
                return null;
            }
            return joinTestMapper.queryByUid(uid);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryJoinTestByUid);
        }
    }

    @Override
    public List<JoinTest> queryByTid(int testId) throws SSException {
        try {
            if (Assert.isNull(testId)){
                return null;
            }
            return joinTestMapper.queryByTid(testId);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryJoinTestByTid);
        }
    }

    @Override
    public JoinTest queryByUidAndTid(JoinTest joinTest) throws SSException {
        try {
            if (Assert.isNull(joinTest)){
                return null;
            }
            return joinTestMapper.queryByUidAndTid(joinTest);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryJoinTestByUidAndTid);
        }
    }

    @Override
    public List<JoinTest> listAll() throws SSException {
        return joinTestMapper.listAll();
    }
}
