package com.service.impl;

import com.dao.UserandteamMapper;
import com.pojo.Userandteam;
import com.pojo.UserandteamExample;
import com.service.UserandteamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WU on 2017/8/30.
 * 对应用户和团队的Service实现类
 * [UserandteamtMapper] [UserandteamService]
 */
@Service
@Transactional
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

    public int deleteUserandteam(int tId)
    {
        try{
            // 新建UserAndTeam对象,符合查询条件
            Userandteam userandteam = new Userandteam();
            userandteam.settId(tId);
            // 将属于team表的数据全部取出来
            List<Userandteam> userandteamList =  selectUserandteam(userandteam,1);
            if (userandteamList==null||userandteamList.size()==0) {
                System.out.println("Team表对应User无联袂关系");
            }else {
                for (int i=0;i<userandteamList.size();i++){
                    Userandteam u = userandteamList.get(i);
                    userandteamMapper.deleteByPrimaryKey(u.getUtId());
                }
            }
            return 1;
        }catch (Exception e){
            return 0;
        }
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
        List<Userandteam> userandteamList = new ArrayList<Userandteam>();
        Userandteam userandteam1 = null;
        //根据uId(用户ID)查找tId（团队编号）
        if(i==0)
        {
            UserandteamExample userandteamExample=new UserandteamExample();
            userandteamExample.createCriteria().andUIdEqualTo(userandteam.getuId());
            userandteamList= userandteamMapper.selectByExample(userandteamExample);

            //userandteamList
            if(userandteamList==null&&userandteamList.size()==0){
                System.out.println("没有查询到数据");
                return null;
            }else {
                System.out.println("返回了List集合");
                return userandteamList;
            }
        }
        if (i==1)
        {
            // 定义它的Example类
            UserandteamExample userandteamExample = new UserandteamExample();
            // 通过uid查找到对象
            userandteamExample.createCriteria().andTIdEqualTo(userandteam.gettId());
            // 查询操作,返回的是一个List
            userandteamList = userandteamMapper.selectByExample(userandteamExample);
            if (userandteamList==null&&userandteamList.size()==0){
                System.out.println("没有查询到数据");
                return null;
            }else {
                // 返回List数组
                return userandteamList;
            }
        }
        if(i==2)
        {
            //根据tid查询用户id
            UserandteamExample userandteamExample=new UserandteamExample();
            userandteamExample.createCriteria().andTIdEqualTo(userandteam.gettId());
            userandteamList= userandteamMapper.selectByExample(userandteamExample);

            System.out.println(userandteamList.get(0).getuId()+"这是用户id");

            //userandteamList
            if(userandteamList==null&&userandteamList.size()==0){
                System.out.println("没有查询到数据");
                return null;
            }else {
                System.out.println("返回了List集合");
                return userandteamList;
            }
        }
        return null;
    }
}
