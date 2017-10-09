package com.service.impl;

import com.dao.*;
import com.dto.AllObj;
import com.dto.General;
import com.pojo.*;
import com.service.DynamicService;
import com.util.TimeGetTrans;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BF on 2017/9/5.
 *
 */
@Service
public class DynamicServiceImpl implements DynamicService {
    // slf4j日志配置
    private static final Logger _LOG = LoggerFactory.getLogger(DynamicServiceImpl.class);

    // 注入DynamicMapper依赖 [对数据库Dynamic表进行操作的Dao层]
    @Autowired
    DynamicMapper dynamicMapper;

    //注入ProjectMapper
    @Autowired
    ProjectMapper projectMapper;

    //注入UserMapepr
    @Autowired
    UserMapper userMapper;

    //注入TaskMapper
    @Autowired
    TaskMapper taskMapper;

    //注入讨论表
    @Autowired
    DiscusMapper discusMapper;

    //注入评论表
    @Autowired
    CommentMapper commentMapper;

    //注入文件表
    @Autowired
    FileMapper fileMapper;

    //注入文件夹表
    @Autowired
    FolderMapper folderMapper;

    //注入团队表
    @Autowired
    TeamMapper teamMapper;

    //注入周报表
    @Autowired
    WeeklyMapper weeklyMapper;

    //注入分组表
    @Autowired
    GroupofteamMapper groupofteamMapper;

    //注入任务清单表
    @Autowired
    TaskinfoMapper taskinfoMapper;


    /**
     * 新增一条动态信息
     * @param dynamic 动态表实体类
     * @return
     */
    public int addDynamic(Dynamic dynamic) {
        try{
            dynamicMapper.insert(dynamic);
            return 1;
        }catch (Exception e){
            System.out.println("输出异常");
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 删除一条动态信息
     * @param dynamicId 根据ID删除表
     * @return
     */
    public int deleteDynamic(int dynamicId) {
        return 0;
    }

    /**
     * 更新一条动态信息 <应该不会用到>
     * @param dynamic 动态表实体类
     * @return
     */
    public int updateDynamic(Dynamic dynamic) {
        return 0;
    }

    /**
     * 查询动态信息  [对应的项目]
     * @param dynamic 动态表实体类
     * @param pId 根据项目id查询
     * @return
     */
    public List<General> selectDynamic(Dynamic dynamic, int pId) {
        List<Dynamic> dynamicList=new ArrayList<Dynamic>();
        List<General> generalList=new ArrayList<General>();
        //根据Pid查询动态列表
        if(pId==0){
            DynamicExample dynamicExample =new DynamicExample();
            dynamicExample.createCriteria().andPIdEqualTo(dynamic.getpId());
            dynamicList= dynamicMapper.selectByExample(dynamicExample);
            for(int i=0;i<dynamicList.size();i++){
                General general=new General();
                Project project = projectMapper.selectByPrimaryKey(dynamicList.get(i).getpId());
                //根据uId查找用户对象
                User user = userMapper.selectByPrimaryKey(dynamicList.get(i).getuId());
                //赋值
                general.setpName(project.getpName());
                general.setUname(user.getuName());
                general.setAction(dynamicList.get(i).getAction());
                general.setDate(dynamicList.get(i).getdTime());
                //判断对哪个表进行了操作
                String table=dynamicList.get(i).getBeTable();

                if(table.equals("task")){
                    //若对task表进行操作，则根据beOperated查询task
                    Task task = taskMapper.selectByPrimaryKey(dynamicList.get(i).getBeOperated());
                    general.setAaName(task.getTaskName());
                    general.setOperateId(task.getTaskId());
                    general.setTable("task");
                    generalList.add(general);
                }else if(table.equals("discus")){
                    //若对discus表进行操作，则根据beOperated查询discus
                    Discus discus = discusMapper.selectByPrimaryKey(dynamicList.get(i).getBeOperated());
                    general.setAaName(discus.getdContent());
                    general.setOperateId(discus.getDiscusId());
                    general.setTable("discus");
                    generalList.add(general);
                }else if(table.equals("comment")){
                    //若对comment表进行操作，则根据beOperated查询comment
                    Comment comment = commentMapper.selectByPrimaryKey(dynamicList.get(i).getBeOperated());
                    general.setAaName(comment.getcContent());
                    general.setOperateId(comment.getcId());
                    general.setTable("comment");
                    generalList.add(general);
                }else if(table.equals("file")){
                    //若对file表进行操作，则根据beOperated查询file
                    File file = fileMapper.selectByPrimaryKey(dynamicList.get(i).getBeOperated());
                    general.setAaName(file.getFileName());
                    general.setOperateId(file.getFileId());
                    general.setTable("file");
                    generalList.add(general);
                }else if(table.equals("folder")){
                    //若对folder表进行操作，则根据beOperated查询folder
                    Folder folder = folderMapper.selectByPrimaryKey(dynamicList.get(i).getBeOperated());
                    general.setAaName(folder.getFolderName());
                    general.setOperateId(folder.getFolderId());
                    general.setTable("folder");
                    generalList.add(general);
                }else if (table.equals("team")){
                    //若对team表进行操作，则根据beOperated查询team
                    Team team = teamMapper.selectByPrimaryKey(dynamicList.get(i).getBeOperated());
                    general.setAaName(team.gettName());
                    general.setOperateId(team.gettId());
                    general.setTable("team");
                    generalList.add(general);
                }else if(table.equals("weekly")){
                    //若对weekly表进行操作，则根据beOperated查询weekly
                    Weekly weekly = weeklyMapper.selectByPrimaryKey(dynamicList.get(i).getBeOperated());
                    general.setAaName("周报");
                    general.setOperateId(weekly.getWeeklyId());
                    general.setTable("weekly");
                    generalList.add(general);
                }
            }
            return generalList;
            //根据uid查询动态列表
        }else if(pId==1){
            DynamicExample dynamicExample = new DynamicExample();
            dynamicExample.createCriteria().andUIdEqualTo(dynamic.getuId());
            dynamicList = dynamicMapper.selectByExample(dynamicExample);
            for(int i=0;i<dynamicList.size();i++){
                General general=new General();
                Project project = projectMapper.selectByPrimaryKey(dynamicList.get(i).getpId());
                //根据uId查找用户对象
                User user = userMapper.selectByPrimaryKey(dynamicList.get(i).getuId());
                //赋值
                general.setpName(project.getpName());
                general.setUname(user.getuName());
                general.setAction(dynamicList.get(i).getAction());
                general.setDate(dynamicList.get(i).getdTime());
                //判断对哪个表进行了操作
                String table=dynamicList.get(i).getBeTable();

                if(table.equals("task")){
                    //若对task表进行操作，则根据beOperated查询task
                    Task task = taskMapper.selectByPrimaryKey(dynamicList.get(i).getBeOperated());
                    general.setAaName(task.getTaskName());
                    general.setOperateId(task.getTaskId());
                    general.setTable("task");
                    generalList.add(general);
                }else if(table.equals("discus")){
                    //若对discus表进行操作，则根据beOperated查询discus
                    Discus discus = discusMapper.selectByPrimaryKey(dynamicList.get(i).getBeOperated());
                    general.setAaName(discus.getdContent());
                    general.setOperateId(discus.getDiscusId());
                    general.setTable("discus");
                    generalList.add(general);
                }else if(table.equals("comment")){
                    //若对comment表进行操作，则根据beOperated查询comment
                    Comment comment = commentMapper.selectByPrimaryKey(dynamicList.get(i).getBeOperated());
                    general.setAaName(comment.getcContent());
                    general.setOperateId(comment.getcId());
                    general.setTable("comment");
                    generalList.add(general);
                }else if(table.equals("file")){
                    //若对file表进行操作，则根据beOperated查询file
                    File file = fileMapper.selectByPrimaryKey(dynamicList.get(i).getBeOperated());
                    general.setAaName(file.getFileName());
                    general.setOperateId(file.getFileId());
                    general.setTable("file");
                    generalList.add(general);
                }else if(table.equals("folder")){
                    //若对folder表进行操作，则根据beOperated查询folder
                    Folder folder = folderMapper.selectByPrimaryKey(dynamicList.get(i).getBeOperated());
                    general.setAaName(folder.getFolderName());
                    general.setOperateId(folder.getFolderId());
                    general.setTable("folder");
                    generalList.add(general);
                }else if (table.equals("team")){
                    //若对team表进行操作，则根据beOperated查询team
                    Team team = teamMapper.selectByPrimaryKey(dynamicList.get(i).getBeOperated());
                    general.setAaName(team.gettName());
                    general.setOperateId(team.gettId());
                    general.setTable("team");
                    generalList.add(general);
                }else if(table.equals("weekly")){
                    //若对weekly表进行操作，则根据beOperated查询weekly
                    Weekly weekly = weeklyMapper.selectByPrimaryKey(dynamicList.get(i).getBeOperated());
                    general.setAaName("周报");
                    general.setOperateId(weekly.getWeeklyId());
                    general.setTable("weekly");
                    generalList.add(general);
                }
            }
            return generalList;
        }
        return null;
    }


    public List<General> QueryList(Dynamic dynamic) {
        DynamicExample dynamicExample = new DynamicExample();
        dynamicExample.createCriteria().andTIdEqualTo(dynamic.gettId());
        dynamicExample.setOrderByClause("d_time DESC");
        List<Dynamic> dynamicList = dynamicMapper.selectByExample(dynamicExample);
        List<General> generalList=new ArrayList<General>();
        for(int i=0;i<dynamicList.size();i++){
            General general=new General();
            Project project = projectMapper.selectByPrimaryKey(dynamicList.get(i).getpId());
            //根据uId查找用户对象
            User user = userMapper.selectByPrimaryKey(dynamicList.get(i).getuId());
            //赋值
            general.setpName(project.getpName());
            general.setUname(user.getuName());
            general.setAction(dynamicList.get(i).getAction());
            general.setDate(dynamicList.get(i).getdTime());
            //判断对哪个表进行了操作
            String table=dynamicList.get(i).getBeTable();

            if(table.equals("task")){
                //若对task表进行操作，则根据beOperated查询task
                Task task = taskMapper.selectByPrimaryKey(dynamicList.get(i).getBeOperated());
                general.setAaName(task.getTaskName());
                general.setOperateId(task.getTaskId());
                general.setTable("task");
                generalList.add(general);
            }else if(table.equals("discus")){
                //若对discus表进行操作，则根据beOperated查询discus
                Discus discus = discusMapper.selectByPrimaryKey(dynamicList.get(i).getBeOperated());
                general.setAaName(discus.getdContent());
                general.setOperateId(discus.getDiscusId());
                general.setTable("discus");
                generalList.add(general);
            }else if(table.equals("comment")){
                //若对comment表进行操作，则根据beOperated查询comment
                Comment comment = commentMapper.selectByPrimaryKey(dynamicList.get(i).getBeOperated());
                general.setAaName(comment.getcContent());
                general.setOperateId(comment.getcId());
                general.setTable("comment");
                generalList.add(general);
            }else if(table.equals("file")){
                //若对file表进行操作，则根据beOperated查询file
                File file = fileMapper.selectByPrimaryKey(dynamicList.get(i).getBeOperated());
                general.setAaName(file.getFileName());
                general.setOperateId(file.getFileId());
                general.setTable("file");
                generalList.add(general);
            }else if(table.equals("folder")){
                //若对folder表进行操作，则根据beOperated查询folder
                Folder folder = folderMapper.selectByPrimaryKey(dynamicList.get(i).getBeOperated());
                general.setAaName(folder.getFolderName());
                general.setOperateId(folder.getFolderId());
                general.setTable("folder");
                generalList.add(general);
            }else if (table.equals("team")){
                //若对team表进行操作，则根据beOperated查询team
                Team team = teamMapper.selectByPrimaryKey(dynamicList.get(i).getBeOperated());
                general.setAaName(team.gettName());
                general.setOperateId(team.gettId());
                general.setTable("team");
                generalList.add(general);
            }else if(table.equals("weekly")){
                //若对weekly表进行操作，则根据beOperated查询weekly
                Weekly weekly = weeklyMapper.selectByPrimaryKey(dynamicList.get(i).getBeOperated());
                general.setAaName("周报");
                general.setOperateId(weekly.getWeeklyId());
                general.setTable("weekly");
                generalList.add(general);
            }
        }
        return generalList;
    }

    public List<AllObj> selectObj(int operateId, String table) {
        List<AllObj> allObjList = new ArrayList<AllObj>();
        AllObj allObj = new AllObj();
        General general = new General();
        general.setTable(table);
        general.setOperateId(operateId);
        if(table.equals("task")){
            Task task = taskMapper.selectByPrimaryKey(general.getOperateId());
            allObj.setTask(task);
            allObj.setType(1);
            allObjList.add(allObj);
        }else if(table.equals("discus")){
            Discus discus = discusMapper.selectByPrimaryKey(general.getOperateId());
            allObj.setDiscus(discus);
            allObj.setType(2);
            allObjList.add(allObj);
        }else if(table.equals("comment")){
            Comment comment = commentMapper.selectByPrimaryKey(general.getOperateId());
            allObj.setComment(comment);
            allObj.setType(3);
            allObjList.add(allObj);
        }else if(table.equals("file")){
            File file = fileMapper.selectByPrimaryKey(general.getOperateId());
            allObj.setFile(file);
            allObj.setType(4);
            allObjList.add(allObj);
        }else if(table.equals("folder")){
            Folder folder = folderMapper.selectByPrimaryKey(general.getOperateId());
            allObj.setFolder(folder);
            allObj.setType(5);
            allObjList.add(allObj);
        }else if(table.equals("team")){
            Team team = teamMapper.selectByPrimaryKey(general.getOperateId());
            allObj.setTeam(team);
            allObj.setType(6);
            allObjList.add(allObj);
        }else if(table.equals("weekly")){
            Weekly weekly = weeklyMapper.selectByPrimaryKey(general.getOperateId());
            allObj.setWeekly(weekly);
            allObj.setType(7);
            allObjList.add(allObj);
        }
        //TODO 不一定需要
// else if(table.equals("groupofteam")){
//            Groupofteam groupofteam = groupofteamMapper.selectByPrimaryKey(general.getOperateId());
//            allObj.setGroupofteam(groupofteam);
//            allObj.setType(8);
//            allObjList.add(allObj);
//        }else if(table.equals("project")){
//            Project project = projectMapper.selectByPrimaryKey(general.getOperateId());
//            allObj.setProject(project);
//            allObj.setType(9);
//            allObjList.add(allObj);
//        }else if(table.equals("taskinfo")){
//            Taskinfo taskinfo = taskinfoMapper.selectByPrimaryKey(general.getOperateId());
//            allObj.setTaskinfo(taskinfo);
//            allObj.setType(10);
//            allObjList.add(allObj);
//        }
        return allObjList;
    }
}
