package repository.service;

import dto.CtmonAdminuserDto;
import dto.JobDepartmentDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IJobDepartmentService {
    List<JobDepartmentDto> GetJobDepartmentAll(String where);
}
