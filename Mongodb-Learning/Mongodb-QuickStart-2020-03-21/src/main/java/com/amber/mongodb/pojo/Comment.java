package com.amber.mongodb.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author: Amber
 */
@Document(collection = "comment")
@Data
// 复合索引
//@CompoundIndex( def = "{'userid': 1, 'nickname': -1}")
public class Comment implements Serializable {

    @Id
    private String id;//主键
    private String content;//吐槽内容
    private Date publishtime;//发布日期 //添加了一个单字段的索引
    @Indexed // 创建索引，但是一般不用代码创建索引
    private String userid;//发布人ID
    private String nickname;//昵称
    private LocalDateTime createdatetime;//评论的日期时间
    private Integer likenum;//点赞数
    private Integer replynum;//回复数
    private String state;//状态
    private String parentid;//上级ID
    private String articleid;
}
