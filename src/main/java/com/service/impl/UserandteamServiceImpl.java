package com.service.impl;

import com.dao.UserandteamMapper;
import com.pojo.Userandteam;
import com.pojo.UserandteamExample;
import com.service.UserandteamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WU on 2017/8/30.
 * 对应用户和团队的Service实现类
 * [UserandteamtMapper] [UserandteamService]
 */
@Service
public class UserandteamServiceImpl implements UserandteamService {
    // 注入UserandteamMapper依赖 [对数据库UserAndTeam表进行操作的Dao层]
    @Autowired
    UserandteamMapper userandteamMapper;

    /**
     * 往[UserandteamService] 表中添加一天新的数据
     * @param userandteam 用户和团队实体类
     * @return
     */
    public int addUserandteam(Userandteam userandteam) {
        userandteamMapper.insert(userandteam);
        return 1;
    }

    public int deleteUserandteam(int utId) {
        return 0;
    }

    public int updateUserandteam(Userandteam userandteam) {
        return 0;
    }


    /**
     * 对userandteam 进行查询
     * @param userandteam 用户和团队实体类
     * @param i 根据什么来查询（0代表ID，1代表名称）
     * @return
     */
    public List<Userandteam> selectUserandteam(Userandteam userandteam, int i) {
        List<Userandteam> userandteamList=new ArrayList<Userandteam>();
        Userandteam userandteam1=null;
        //根据uId(用户ID)查找tId（团队编号）
        if(i==0)
        {
            UserandteamExample userandteamExample=new UserandteamExample();
            //通过uid查找到对象
            userandteamExample.createCriteria().andUIdEqualTo(userandteam.getuId());
            //找到的对象放到List集合中去
            userandteamList=userandteamMapper.selectByExample(userandteamExample);
            //userandteamList
            if(userandteamList==null&&userandteamList.size()==0){
                System.out.println("返回了空");
                return null;
            }else {
                System.out.println("返回了List集合");
                return userandteamList;
            }
        }
        return null;
    }
}
