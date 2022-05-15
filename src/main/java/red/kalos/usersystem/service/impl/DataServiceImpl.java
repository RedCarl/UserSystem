package red.kalos.usersystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import red.kalos.usersystem.dao.DataDao;
import red.kalos.usersystem.entity.Data;
import red.kalos.usersystem.service.DataService;

import java.util.List;

/**
 * (Data)表服务实现类
 *
 * @author makejava
 * @since 2022-05-15 20:45:28
 */
@Service("dataService")
@Transactional
public class DataServiceImpl implements DataService {

    @Autowired
    private DataDao dataDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Data queryById(Integer id) {
        return this.dataDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param data 筛选条件
     * @param page 页码
     * @param pageSize 页大小
     * @return 查询结果
     */
    @Override
    public PageInfo<Data> queryByPage(Data data, int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Data> list = this.dataDao.queryAllByLimit(data);
        return new PageInfo<>(list);
    }

    /**
     * 新增数据
     *
     * @param data 实例对象
     * @return 实例对象
     */
    @Override
    public Data insert(Data data) {
        this.dataDao.insert(data);
        return data;
    }

    /**
     * 修改数据
     *
     * @param data 实例对象
     * @return 实例对象
     */
    @Override
    public Data update(Data data) {
        this.dataDao.update(data);
        return this.queryById(data.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.dataDao.deleteById(id) > 0;
    }
}
