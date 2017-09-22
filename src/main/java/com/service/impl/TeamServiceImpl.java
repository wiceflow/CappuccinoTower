package com.service.impl;

import com.dao.TeamMapper;
import com.pojo.Team;
import com.pojo.Userandteam;
import com.service.TeamService;
import com.service.UserandteamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by chen on 2017/8/29.
 * 团队表的Service层 [Team]
 */
@Service
@Transactional
public class TeamServiceImpl implements TeamService {
    // 注入TeamMapper依赖 [对数据库Team表进行操作的Dao层]
    @Autowired
    private TeamMapper teamMapper;

    // 注入UserAndTeamService依赖 [对数据库UserAndTeam表进行间接操作]
    @Autowired
    private UserandteamService userandteamService;

    /**
     * 新增一个团队表
     * @param team 团队实体类
     * @param uId 用户ID
     * @return 返回此次新增数据所自增的主键
     */
    public int addTeam(Team team,int uId) {
        // 团队与用户表的关系--> 新建一个管队的时候创建者必为超级管理员
        Userandteam u = new Userandteam();
        teamMapper.insert(team);
        u.settId(team.gettId());
        u.setuId(uId);
        u.setType(1);
        // 插入新的用户与团队关系
        userandteamService.addUserandteam(u);
        return team.gettId();
    }

    public int deleteTeam(int tId) {
        try {
            // 删除user和team的联袂关系
            userandteamService.deleteUserandteam(tId);
            // 删除team团队
            teamMapper.deleteByPrimaryKey(tId);
            // 成功删除
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }

    }

    public int updateTeam(Team team) {
        return 0;
    }

    public List<Team> selectTeam(Team team, int i) {
        return null;
    }
}
