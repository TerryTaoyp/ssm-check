(function(){

    var site = {
        //这是前端本地需要配置的，用来看自己写的页面
        website:'http://localhost:8080/', //站点地址
        //静态资源地址
        staticWebsite: 'http://www.appraisal.com/ssm-check/Home/src/main/webapp/resources/'
    }
    // 页面内容
    _ajax = {
        status: 0, //0-前端调试，1-后端调试, 2-后端部署
        website: site.website,
        staticWebsite: site.staticWebsite,
        //统一错误信息入口
        msg:{
            0: '网络加载错误'
        },
        //ajax地址信息
        url: {
            //系统考核
            system:{
               //角色管理
               role:{
                    // 列表
                    list:{
                        change: site.website + 'role/ajax/update'
                        // change: site.staticWebsite + 'mock/role.json'
                    },
                    // 添加
                    add:{
                        // 暂无
                    }
                },
                //权限管理
                jurisdiction:{
                    // 列表
                    list:{
                        change: site.staticWebsite + 'mock/jurisdiction.json'
                    },
                    // 添加
                    add:{
                        // 暂无
                    }
                },
                //部门管理
                department:{
                    // 列表
                    list:{
                        change: site.staticWebsite + 'mock/department.json'
                    },
                    // 添加
                    add:{
                        // 暂无
                    }
                },
                //人员管理
                personnel:{
                    // 列表
                    list:{
                        change: site.staticWebsite + 'mock/personnel.json'
                    }
                },
                //管辖分配
                allot:{
                    // 列表
                    list:{
                        change: site.staticWebsite + 'mock/allot.json'
                    }
                },
                //账号管理
                account:{
                    // 列表
                    list:{
                        change: site.staticWebsite + 'mock/account.json'
                    }
                },
            },
            //考核考核
            evaluation:{
               //考核计划
               plan_management:{
                    // 列表
                    list:{
                        change: site.staticWebsite + 'mock/plan_management.json'
                    },
                    // 添加
                    add:{
                        // 暂无
                    }
                },
                //考核分配
                allot:{
                    // 列表
                    list:{
                        change: site.staticWebsite + 'mock/allot.json'
                    }
                },
                //月/季度考核管理
                month:{
                    // 工作计划列表
                    plan_list:{
                        change: site.staticWebsite + 'mock/plan_list.json'
                    },
                    // 绩效考核列表
                    evaluation_list:{
                        change: site.staticWebsite + 'mock/evaluation_list.json'
                    },
                },
                //年度考核管理
                year:{
                    // 绩效综合列表
                    synthetical_list:{
                        change: site.staticWebsite + 'mock/synthetical_list.json'
                    },
                    // 能力指标列表
                    ability_list:{
                        change: site.staticWebsite + 'mock/ability_list.json'
                    },
                }
            },
            //测评模块
            exam:{
               //考核计划
               plan_management:{
                    // 列表
                    list:{
                        change: site.staticWebsite + 'mock/plan_management.json'
                    },
                    // 添加
                    add:{
                        // 暂无
                    }
                }
            },
            //成绩查询
            performance:{
               //考核计划
               plan_management:{
                    // 列表
                    list:{
                        change: site.staticWebsite + 'mock/plan_management.json'
                    },
                    // 添加
                    add:{
                        // 暂无
                    }
                }
            }
        },
    }
})();