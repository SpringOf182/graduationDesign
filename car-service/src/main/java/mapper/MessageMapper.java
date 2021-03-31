package mapper;


import com.zy.entity.Message;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ExampleMapper;

import java.sql.ResultSet;

/**
 * Message数据访问Mapper接口.
 * @author Ying
 */
public interface MessageMapper extends BaseMapper<Message>, ExampleMapper<Message> {
    ResultSet queryNewMessage(@Param(value = "receiverUID") String receiverUID);

}