package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.Tag;
import cn.broccoli.blog.po.TagExample;
import cn.broccoli.blog.utils.TagResultMap;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TagMapper {
    int countByExample(TagExample example);

    int deleteByExample(TagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Tag tag);

    int insertSelective(Tag record);

    List<Tag> selectByExample(TagExample example);

    Tag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Tag record, @Param("example") TagExample example);

    int updateByExample(@Param("record") Tag record, @Param("example") TagExample example);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);
    
    List<Tag> selectTagAll();
    
    List<TagResultMap> selectByArticleId(Integer articleid);
    
    int updateArticleNumById(List<TagResultMap> taglist);
    
}