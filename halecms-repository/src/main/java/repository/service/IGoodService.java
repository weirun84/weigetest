package repository.service;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IGoodService {
     int GetGoodsCount();
}
