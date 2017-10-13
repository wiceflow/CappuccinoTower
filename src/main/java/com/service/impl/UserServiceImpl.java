package com.service.impl;

import com.dao.GroupofteamMapper;
import com.dao.TeamMapper;
import com.dao.UserMapper;
import com.dao.UserandteamMapper;
import com.dto.TeamforJsp;
import com.pojo.*;
import com.service.TeamService;
import com.service.UserService;
import com.service.UserandteamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BF on 2017/8/29.
 * 对应用户表的Service实现类
 * [UserMapper] [UserService]
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    // 注入UserMapper依赖 [对数据库进行操作的Dao层]
    @Autowired
    UserMapper userMapper;
    // 注入TeamService依赖 [对数据库进行操作的Sercie层]
    @Autowired
    TeamService teamService;
    //注入团队和用户依赖
    @Autowired
    UserandteamService userandteamService;

    @Autowired
    UserandteamMapper userandteamMapper;

    @Autowired
    TeamMapper teamMapper;

    @Autowired
    GroupofteamMapper groupofteamMapper;


    public int addUser(User user, Team team) {
        List<User> userList = null;
        //创建Example对象，使用createCtiteria方法以uName查询数据库
        UserExample userExample = new UserExample();
        // where uName = uName;
        userExample.createCriteria().andUNameEqualTo(user.getuName());
        // Where uEmail = uEmail  -->  where uName = uName or uEmail = uEmail;
        userExample.or(userExample.createCriteria().andUEmailEqualTo(user.getuEmail()));
        //userList接受查询结果
        userList = userMapper.selectByExample(userExample);
        //若结果为空或者长度为0
        if (userList == null || userList.size() == 0) {
            // 添加用户
            userMapper.insert(user);
            // 创建新的团队--> 创建者默认为超级管理员
            team.setIsgroup(0);
            teamService.addTeam(team,user.getuId());
            return 1;
        } else {
            return 0;
        }

    }

    public int addUser(User user) {
        List<User> userList = null;
        String uName = user.getuName();
        //创建Example对象，使用createCtiteria方法以uName查询数据库
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUEmailEqualTo(uName);
        //userList接受查询结果
        userList = userMapper.selectByExample(userExample);
        if (userList == null || userList.size() == 0) {
            //添加用户
            userMapper.insert(user);
            return 1;
        }
        return 0;
    }

    public int deleteUser(int uId) {
        userMapper.deleteByPrimaryKey(uId);
        return 0;
    }

    public int updateUser(User user) {
        userMapper.updateByPrimaryKey(user);
        return 1;
    }

    /**
     * 查找与选择 [User]
     *
     * @param user 用户实体类
     * @param i    根据什么来查找（0代表ID，1代表用户名，2代表邮箱）
     * @return 若查询为空则判断返回空，查询不为空则返回
     */
    public List<User> selectUser(User user, int i) {
        List<User> userList = new ArrayList<User>();
        User user1 = null;
        //用ID主键进行查询
        if (i == 0) {
            user1 = userMapper.selectByPrimaryKey(user.getuId());
            userList.add(user1);
        }
        //用用户名查询
        else if (i == 1) {
            String uName = user.getuName();
            UserExample userExample = new UserExample();
            userExample.createCriteria().andUNameEqualTo(uName);
            userList = userMapper.selectByExample(userExample);
        }
        //用用户邮箱查询
        else if (i == 2) {
            String uEmail = user.getuEmail();
            UserExample userExample = new UserExample();
            userExample.createCriteria().andUEmailEqualTo(uEmail);
            userList = userMapper.selectByExample(userExample);
        }

        //若查询为空则返回null
        if (userList == null || userList.size() == 0) {
            return null;
        }
        //否则返回这个list
        else {
            return userList;
        }
    }

    /**
     * 对uName进行模糊查询
     *
     * @param uName
     * @return
     */
    public List<User> listByUname(String uName) {
        List<User> listByUname = null;
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        //拼接SQL语句
        if (StringUtils.hasText(uName)) {
            uName = "%" + uName + "%";
        }
        if (StringUtils.hasText(uName)) {
            criteria.andUNameLike(uName);
        }
        //select u_id, u_email, u_password, u_picture, u_name from user WHERE u_name like '%小%';
        //将按照uName查找到的List 返回
        listByUname = userMapper.selectByExample(userExample);
        if(listByUname!=null&&listByUname.size()!=0){
            return listByUname;
        }
        return null;
    }

    /**
     * 遍历整个User表   稍后删掉
     * @return
     */
    public List<User> QueryList(int tId){
        Userandteam userandteam = new Userandteam();
        //将tId放到userandteam对象中去
        userandteam.settId(tId);
        //根据tId（团队ID）查询uId（用户编号）通过userandteam表
        //得到团队中的用户 List
        List<Userandteam> userandteamList = userandteamService.selectUserandteam(userandteam,2);

        List<User> userList = new ArrayList<User>();
        for(int i=0;i<userandteamList.size();i++){
            UserExample userExample = new UserExample();
            userExample.createCriteria().andUIdEqualTo(userandteamList.get(i).getuId());
            List<User> users = userMapper.selectByExample(userExample);
            userList.add(users.get(0));
        }
        //判断
        if(userList!=null||userList.size()!=0){
            return userList;
        }else{
            System.out.println("没有查询到1111");
            return null;
        }

    }

    /**
     * 根据tId返回一个DTO类型
     * @param tId
     * @return
     */
    public List<TeamforJsp> QueryByTid(int tId){
        UserandteamExample userandteamExample=new UserandteamExample();
        userandteamExample.createCriteria().andTIdEqualTo(tId);
        List<TeamforJsp> teamforJspList=new ArrayList<TeamforJsp>();
        List<Userandteam> userandteamList = userandteamMapper.selectByExample(userandteamExample);
        Team team = teamMapper.selectByPrimaryKey(tId);
        for(int i=0;i<userandteamList.size();i++){
            TeamforJsp teamforJsp=new TeamforJsp();
            User user = userMapper.selectByPrimaryKey(userandteamList.get(i).getuId());

            teamforJsp.settId(userandteamList.get(i).gettId());
            teamforJsp.setType(userandteamList.get(i).getType());

            teamforJsp.settName(team.gettName());
            teamforJsp.setIsgroup(team.getIsgroup());

            teamforJsp.setuId(user.getuId());
            teamforJsp.setuName(user.getuName());
            teamforJsp.setuEmail(user.getuEmail());
            if(team.getIsgroup()!=0){
                //带改善
            }else{

            }
            teamforJspList.add(teamforJsp);
        }
        if(teamforJspList!=null&&teamforJspList.get(0).gettId()!=0){
            System.out.println("--->queryByTid---->Service");
            return teamforJspList;
        }
        return null;
    }
}
