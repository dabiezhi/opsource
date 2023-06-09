// ---Auto Generated by Only4Play ---
package com.only4play.flow.domain.node.mapper;

import com.only4play.common.mapper.DateMapper;
import com.only4play.common.mapper.GenericEnumMapper;
import com.only4play.flow.domain.node.Node;
import com.only4play.flow.domain.node.dto.creator.NodeCreator;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {GenericEnumMapper.class, DateMapper.class})
public interface NodeMapper {
    NodeMapper INSTANCE = Mappers.getMapper(NodeMapper.class);

    Node creator2Entity(NodeCreator dto);

}
