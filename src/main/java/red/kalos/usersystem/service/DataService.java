package red.kalos.usersystem.service;

import com.github.pagehelper.PageInfo;
import red.kalos.usersystem.entity.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Data)表服务接口
 *
 * @author makejava
 * @since 2022-05-15 20:45:28
 */
public interface DataService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Data queryById(Integer id);

    /**
     * 分页查询
     *
     * @param data 筛选条件
     * @param page 页码
     * @param pageSize 页大小
     * @return 查询结果
     */
    PageInfo<Data> queryByPage(Data data, int page, int pageSize);

    /**
     * 新增数据
     *
     * @param data 实例对象
     * @return 实例对象
     */
    Data insert(Data data);

    /**
     * 修改数据
     *
     * @param data 实例对象
     * @return 实例对象
     */
    Data update(Data data);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
