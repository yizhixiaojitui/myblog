package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.ArticleSort;
import cn.broccoli.blog.utils.SortList;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ArticleSortMapper {

    int deleteByPrimaryKey(Integer sortArticleId);

    boolean insert(ArticleSort record);

    int insertSelective(ArticleSort record);

    ArticleSort selectByPrimaryKey(Integer sortArticleId);
 
    int updateByPrimaryKeySelective(ArticleSort record);

    int updateByPrimaryKey(ArticleSort record);
    
    List<Map<Integer, String>> selectByUserId(@Param("userid")int userId);
    
    List<SortList> selectTagsBylimit(@Param("userid")Integer userid,@Param("page") int page,
    		@Param("limit") int limit,@Param("sortArticleId")String sortArticleId,@Param("sortArticleName") String sortArticleName);
    
    int selectTagBylimitCount(@Param("userid")Integer userid,@Param("sortArticleId")String sortArticleId,@Param("sortArticleName") String sortArticleName);

    boolean deleteTagsById(List<SortList> ids);

    int updateById(SortList tl);

    ArticleSort selectByName(@Param("userid") Integer userid,@Param("name")String name);

}