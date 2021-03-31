package mapper;

import com.zy.entity.Order;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ExampleMapper;

/**
 * Order数据访问Mapper接口.
 * @author Ying
 */
public interface OrderMapper extends BaseMapper<Order>, ExampleMapper<Order> {

}