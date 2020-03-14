package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.ArticleSort;
import cn.broccoli.blog.utils.SortList;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ArticleSortMapper {
	//根据文章分类id删除文章分类
    int deleteByPrimaryKey(Integer sortArticleId);
    //插入文章分类
    boolean insert(ArticleSort record);

    int insertSelective(ArticleSort record);
    //根据分类id查询分类
    ArticleSort selectByPrimaryKey(Integer sortArticleId);
    //
    int updateByPrimaryKeySelective(ArticleSort record);

    int updateByPrimaryKey(ArticleSort record);
    //根据用户id查询文章分类列表
    List<Map<Integer, String>> selectByUserId(@Param("userid")int userId);
    //根据分页信息查询文章分类列表
    List<SortList> selectTagsBylimit(@Param("userid")Integer userid,@Param("page") int page,
    		@Param("limit") int limit,@Param("sortArticleId")String sortArticleId,@Param("sortArticleName") String sortArticleName);
    //查询文章分类总行数
    int selectTagBylimitCount(@Param("userid")Integer userid,@Param("sortArticleId")String sortArticleId,@Param("sortArticleName") String sortArticleName);
    //根据id list删除文章分类
    boolean deleteTagsById(List<SortList> ids);
    //修改文章分类
    int updateById(SortList tl);
    //查询文章分类详细信息
    ArticleSort selectByName(@Param("userid") Integer userid,@Param("name")String name);

}