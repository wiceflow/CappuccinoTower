package com.service.impl;

import com.dao.TeamMapper;
import com.pojo.Team;
import com.pojo.TeamExample;
import com.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**对应团队的Service实现类
 * [TeamMapper] [TeamService]
 * Created by WU on 2017/8/29.
 */
@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    TeamMapper teamMapper;
    /**
     * 创建一个团队
     * @param team 小组实体类
     * @return
     */
    public int addTeam(Team team) {
        teamMapper.insert(team);
        System.out.println(team.getTId());
        return team.getTId();
    }

//    /**
//     * 查询Id
//     * @param team 根据团队名称查找团队id
//     * @return
//     */
//    public int selectIdByName(Team team){
//        String TName=team.getTName();
//        //使用Exampel对Team表进行查询
//        TeamExample teamExample=new TeamExample();
//        //根据团队名称查找编号
//        //select * from Team where TName=TName(传过来的项目名);
//        teamExample.createCriteria().andTNameEqualTo(TName);
//        List<Team> teamList=null;
//        teamList=teamMapper.selectByExample(teamExample);
//        if (teamList==null||teamList.size()==0)
//        {
//
//        }
//        Team team1 = teamList.get(0);
//        //将team1中的id 传到 addProjectService（）中
//        return team1.getTId();
//    }


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
