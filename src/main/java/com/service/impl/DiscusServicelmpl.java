package com.service.impl;

import com.dao.AlldiscusMapper;
import com.dao.DiscusMapper;
import com.dao.ProjectMapper;
import com.pojo.Alldiscus;
import com.pojo.Discus;
import com.pojo.DiscusExample;
import com.pojo.Project;
import com.service.DiscusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WU on 2017/8/29.
 * 对应讨论表的Service实现类
 * [DiscusMapper] [DiscusService]
 */
@Service
@Transactional
public class DiscusServicelmpl implements DiscusService {
    //注入讨论表Mapper
    @Autowired
    DiscusMapper discusMapper;
    @Autowired
    //注入讨论总表Mapper
    AlldiscusMapper alldiscusMapper;
    @Autowired
    //注入项目表Mapper
    ProjectMapper projectMapper;

    /**
     * 添加一个新的讨论
     * @param discus 讨论表实体类
     * @param project
     * @return
     */
    public Discus addDiscus(Discus discus, Project project) {
        //判断项目表中是否有讨论总表的id，若有则将讨论表加入其中，若无则新建讨论总表
        if (project.getDiscusallid()!=null){
            //将讨论总表的id加入讨论表
            discus.setDiscusallId(project.getDiscusallid());
            discusMapper.insert(discus);
            return discus;
        }else {
            Alldiscus alldiscus=new Alldiscus();
            alldiscusMapper.insert(alldiscus);
            //根据创建的讨论总表返回ID
            Project project1 = projectMapper.selectByPrimaryKey(project.getpId());
            project1.setDiscusallid(alldiscus.getDiscusallId());
            projectMapper.updateByPrimaryKeyWithBLOBs(project1);
            //将讨论总表id放入讨论表中
            discus.setDiscusallId(alldiscus.getDiscusallId());
            discusMapper.insert(discus);
            return discus;
        }
    }

    public int deleteDiscus(int discusId) {
        return 0;
    }

    public int updateDiscus(Discus discus) {
        return 0;
    }

    public List<Discus> select(Discus discus, int discusId) {
        List<Discus> discusList=new ArrayList<Discus>();
        Discus discus1=null;
        if (discusId==0){
            discus1=discusMapper.selectByPrimaryKey(discus.getDiscusId());
            if (discus1!=null){
                discusList.add(discus1);
                return discusList;
            }
        }
        return null;
    }

    /**
     * 根据项目id 遍历出该id所有的讨论
     * @param pId
     * @return
     */
    public List<Discus> QueryDiscus(int pId){
        Project project = projectMapper.selectByPrimaryKey(pId);
        System.out.println(project.getDiscusallid()+"这是总表的ID");
        DiscusExample discusExample=new DiscusExample();
        discusExample.createCriteria().andDiscusallIdEqualTo(project.getDiscusallid());
        List<Discus> discusList = discusMapper.selectByExampleWithBLOBs(discusExample);
        if(discusList!=null&&discusList.size()!=0){
            System.out.println("quersert返回");
            return discusList;
        }
        return null;
    }
}
