package com.service.impl;

import com.dao.TeamMapper;
import com.pojo.Team;
import com.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chen on 2017/8/29.
 * 团队表的Service层 [Team]
 */
@Service
public class TeamServiceImpl implements TeamService {
    //注入TeamMapper依赖 [对数据库Team表进行操作的Dao层]
    @Autowired
    private TeamMapper teamMapper;

    /**
     * 新增一个团队表
     * @param team 团队实体类
     * @return 返回此次新增数据所自增的主键
     */
    public int addTeam(Team team) {
        teamMapper.insert(team);
        return team.gettId();
    }

    public int deleteTeam(int tId) {
        return 0;
    }

    public int updateTeam(Team team) {
        return 0;
    }

    public List<Team> selectTeam(Team team, int i) {
        return null;
    }
}
