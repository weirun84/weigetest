package repository.service;

import com.halecms.infrastructure.sql.mysql.page.Pager;
import dto.JobpositionDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface IJobPositionService {
    int AddJobPosition(JobpositionDto record);

    int DelJobPosition(int id);

    int DelJobPosition(List<JobpositionDto> id);

    int UpdateJobPosition(JobpositionDto record);

    int DelJobPositionInfo(JobpositionDto id);

    JobpositionDto GetJobPositionInfo(int id);



    Pager<JobpositionDto> PageJobPosition(int currPage, int pageSize, JobpositionDto friend);
}
