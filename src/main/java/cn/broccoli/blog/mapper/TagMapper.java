package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.Tag;
import cn.broccoli.blog.utils.TagResultMap;

import java.util.List;

public interface TagMapper {
    
    int deleteByPrimaryKey(Integer id);

    int insert(Tag tag);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);
    
    List<Tag> selectTagAll();
    
    List<TagResultMap> selectByArticleId(Integer articleid);
    
    int updateArticleNumById(List<TagResultMap> taglist);
    
}