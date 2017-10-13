package com.service.impl;

import com.dao.*;
import com.dto.TeamforJsp;
import com.pojo.*;
import com.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WU on 2017/9/22.
 */
@Service
@Transactional
public class GroupServiceImpl implements GroupService {
    @Autowired
    TeamMapper teamMapper;

    @Autowired
    GroupofteamMapper groupofteamMapper;

    @Autowired
    UserandgroupMapper userandgroupMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserandteamMapper userandteamMapper;

    /**
     * 在团队中新增分组
     * @param uId
     * @return
     */
    public int addGroup(int[] uId,Groupofteam groupofteam) {
        System.out.println("新建分组------>Service");
            groupofteamMapper.insert(groupofteam);
        for (int i=0;i<uId.length;i++){
            Userandgroup userandgroup=new Userandgroup();
            userandgroup.setgId(groupofteam.getgId());
            userandgroup.setuId(uId[i]);
            userandgroupMapper.insert(userandgroup);
       }
        return 1;
    }

    public int deleteGroup(int gId) {
        return 0;
    }

    public int updateGroup(Groupofteam group) {
        return 0;
    }


    /**
     *
     * @param group 分组实体类
     * @param gId 根据ID进行查询
     * @return
     */
    public List<Groupofteam> selectGroup(Groupofteam group, int gId) {
        System.out.println("进入分组Service---->");
       List<Groupofteam> groupList=new ArrayList<Groupofteam>();

       //gid为0时，则根据tid进行查找
       if(gId==0){
           Team team = teamMapper.selectByPrimaryKey(group.gettId());
           if(team.getIsgroup()!=0){
               GroupofteamExample groupofteamExample=new GroupofteamExample();
               groupofteamExample.createCriteria().andTIdEqualTo(group.gettId());
               groupList= groupofteamMapper.selectByExample(groupofteamExample);
               if (groupList!=null&&groupList.get(0).getgName()!=null){
                   System.out.println("从qery的Service返回----->");
                   return groupList;
               }
           }
         return null;
       }
        return null;
    }


    /**
     * 根据gid查找返回
     * @param gId
     * @return
     */
    public List<TeamforJsp> SelectUserByGid(int gId){
        System.out.println("进入了SelectUserByGid------->Service");
        UserandgroupExample userandgroupExample=new UserandgroupExample();
        userandgroupExample.createCriteria().andGIdEqualTo(gId);
        List<Userandgroup> userandgroupList = userandgroupMapper.selectByExample(userandgroupExample);
        List<TeamforJsp> teamforJspList=new ArrayList<TeamforJsp>();
        if(userandgroupList!=null&&userandgroupList.size()!=0) {
            for (int i = 0; i < userandgroupList.size(); i++) {
                TeamforJsp teamforJsp = new TeamforJsp();
                //根据用户的ID 查出用户的全部信息
                User user = userMapper.selectByPrimaryKey(userandgroupList.get(i).getuId());
                //根据gid 查出所属的团队
                Groupofteam groupofteam = groupofteamMapper.selectByPrimaryKey(gId);
                //根据用户ID，团队ID 确定身份
                UserandteamExample userandteamExample=new UserandteamExample();
                userandteamExample.createCriteria().andTIdEqualTo(groupofteam.gettId()).andUIdEqualTo(user.getuId());
                List<Userandteam> userandteams = userandteamMapper.selectByExample(userandteamExample);

                //将查到的User中的信息放到TeamforJSP 的DTO中
                teamforJsp.setuId(user.getuId());
                teamforJsp.setuName(user.getuName());
                teamforJsp.setuEmail(user.getuEmail());

                teamforJsp.setgName(groupofteam.getgName());
                teamforJsp.setgId(gId);
                try{
                    teamforJsp.setType(userandteams.get(0).getType());
                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("该团队中没有这个Uid的成员");
                }


                teamforJspList.add(teamforJsp);
            }
            if(teamforJspList!=null&&teamforJspList.get(0).getuName()!=null){
                return teamforJspList;
            }
        }
        return null;
    }
}
