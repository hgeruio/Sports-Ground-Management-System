package com.example.mapper;
import com.example.domain.Data;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Mapper
public interface DataMapper {
    public List<Data> findByRequired(Data data);
}
