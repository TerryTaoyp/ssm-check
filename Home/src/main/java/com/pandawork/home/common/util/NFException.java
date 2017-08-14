package com.pandawork.home.common.util;

import com.pandawork.core.common.exception.IBizExceptionMes;

/**
 * NFException
 *
 * @author: zhangteng
 * @time: 2015/3/24 16:55
 */
public enum  NFException implements IBizExceptionMes {
    SystemException("系统内部异常", 1),

    //用户名
    NewUserFailed("添加用户失败",101),
    ListAllUserFailed("列出所有用户失败",102),
    UpdateUserFailed("更新用户信息",103),
    DelUserFailed("删除用户",104),


    //博客
    BlogListFailed("博客添加失败",201),
    QueryByBlogNameFailed("根据名字查找博客失败",202),
    CountAllBLogFailed("计算所有博客数量失败",203),
    QueryByBlogTypeFailed("根据类型查找博客失败",204),
    AddBlogFailed("新增博客失败",205),
    DelBlogByIdFailed("根据ID删除博客失败",206),
    DelBlogByNameFailed("根据名字删除博客失败",207),
    UpdateBlogFailed("更新博客失败",208)

    ;

    private String msg;

    private Integer code;

    NFException(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }


    @Override
    public String getMes() {
        return null;
    }

    @Override
    public int getCode() {
        return 0;
    }
}
