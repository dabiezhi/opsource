// ---Auto Generated by Only4Play ---
package com.only4play.flow.domain.cmp.mapper;

import com.only4play.common.mapper.DateMapper;
import com.only4play.common.mapper.GenericEnumMapper;
import com.only4play.flow.domain.cmp.dto.vo.CmpParamVO;
import com.only4play.flow.domain.cmp.dto.vo.CmpVO;
import com.only4play.flow.domain.cmp.response.CmpParamResponse;
import com.only4play.flow.domain.cmp.response.CmpResponse;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {GenericEnumMapper.class, DateMapper.class})
public interface CmpParamMapper {
    CmpParamMapper INSTANCE = Mappers.getMapper(CmpParamMapper.class);

    CmpParamResponse vo2Response(CmpParamVO vo);
}