// ---Auto Generated by Only4Play ---
package com.only4play.flow.domain.chain.mapper;

import com.only4play.common.mapper.DateMapper;
import com.only4play.common.mapper.GenericEnumMapper;
import com.only4play.flow.domain.Chain;
import com.only4play.flow.domain.chain.creator.ChainCreator;
import com.only4play.flow.domain.chain.query.ChainQuery;
import com.only4play.flow.domain.chain.request.ChainCreateRequest;
import com.only4play.flow.domain.chain.request.ChainQueryRequest;
import com.only4play.flow.domain.chain.request.ChainUpdateRequest;
import com.only4play.flow.domain.chain.response.ChainResponse;
import com.only4play.flow.domain.chain.updater.ChainUpdater;
import com.only4play.flow.domain.chain.vo.ChainVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(
    uses = {
        GenericEnumMapper.class,
        DateMapper.class
    }
)
public interface ChainMapper {
  ChainMapper INSTANCE = Mappers.getMapper(ChainMapper.class);

  Chain dtoToEntity(ChainCreator dto);

  ChainUpdater request2Updater(ChainUpdateRequest request);

  ChainCreator request2Creator(ChainCreateRequest request);

  ChainQuery request2Query(ChainQueryRequest request);

  ChainResponse vo2Response(ChainVO vo);

  default ChainResponse vo2CustomResponse(ChainVO vo) {
    ChainResponse response = vo2Response(vo);
    return response;
  }
}
