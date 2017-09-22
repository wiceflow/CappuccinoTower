package com.util;

import com.dao.*;
import com.dto.General;
import com.pojo.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 2017/9/14.
 */
public class ActionJudge {

    //项目Mapper
    private ProjectMapper projectMapper;

    //用户Mapper
    private UserMapper userMapper;

    //任务Mapper
    private TaskMapper taskMapper;

    //讨论Mapper
    private DiscusMapper discusMapper;

    //评论Mapper
    private CommentMapper commentMapper;

    //文件Mapper
    private FileMapper fileMapper;

    //文件夹Mapper
    private FolderMapper folderMapper;

    //团队Mapper
    private TeamMapper teamMapper;

    public List<General> checkgeneral(List<Dynamic> dynamicList){
        List<General> generalList=new ArrayList<General>();
        for(int i=0;i<dynamicList.size();i++){
            General general=new General();
            Project project = projectMapper.selectByPrimaryKey(dynamicList.get(i).getpId());
            System.out.println(dynamicList.get(i).getDynamicId()+"动态表id");
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
                general.setTaskName(task.getTaskName());
                generalList.add(general);
            }else if(table.equals("discus")){
                //若对discus表进行操作，则根据beOperated查询discus
                Discus discus = discusMapper.selectByPrimaryKey(dynamicList.get(i).getBeOperated());
                general.setdContent(discus.getdContent());
                generalList.add(general);
            }else if(table.equals("comment")){
                //若对comment表进行操作，则根据beOperated查询comment
                Comment comment = commentMapper.selectByPrimaryKey(dynamicList.get(i).getBeOperated());
                general.setcContent(comment.getcContent());
                generalList.add(general);
            }else if(table.equals("file")){
                //若对file表进行操作，则根据beOperated查询file
                File file = fileMapper.selectByPrimaryKey(dynamicList.get(i).getBeOperated());
                general.setFileName(file.getFileName());
                generalList.add(general);
            }else if(table.equals("folder")){
                //若对folder表进行操作，则根据beOperated查询folder
                Folder folder = folderMapper.selectByPrimaryKey(dynamicList.get(i).getBeOperated());
                general.setFolderName(folder.getFolderName());
                generalList.add(general);
            }else if (table.equals("team")){
                //若对team表进行操作，则根据beOperated查询team
                Team team = teamMapper.selectByPrimaryKey(dynamicList.get(i).getBeOperated());
                general.settName(team.gettName());
                generalList.add(general);
            }
        }
        return generalList;
    }
}
