package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.FriendlyLink;
import cn.broccoli.blog.po.FriendlyLinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FriendlyLinkMapper {
    int countByExample(FriendlyLinkExample example);

    int deleteByExample(FriendlyLinkExample example);

    int deleteByPrimaryKey(Short linkId);

    boolean insert(FriendlyLink record);

    int insertSelective(FriendlyLink record);

    List<FriendlyLink> selectByExample(FriendlyLinkExample example);

    FriendlyLink selectByPrimaryKey(Short linkId);

    int updateByExampleSelective(@Param("record") FriendlyLink record, @Param("example") FriendlyLinkExample example);

    int updateByExample(@Param("record") FriendlyLink record, @Param("example") FriendlyLinkExample example);

    int updateByPrimaryKeySelective(FriendlyLink record);

    int updateByPrimaryKey(FriendlyLink record);
    
    List<FriendlyLink> selectAll();
    
    List<FriendlyLink> selectLinkByPage(@Param("page") int page,@Param("limit") int limit,@Param("linkId") String linkId,@Param("linkName") String linkName);

    int selectCount(@Param("linkId") String linkId,@Param("linkName") String linkName);
    
    boolean deleteFriendlyLink(List<FriendlyLink> ids);
    
   
}