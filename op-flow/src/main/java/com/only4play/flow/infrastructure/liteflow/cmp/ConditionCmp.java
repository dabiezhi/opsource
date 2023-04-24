package com.only4play.flow.infrastructure.liteflow.cmp;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.core.NodeIfComponent;

/**
 * @author tsy
 * Created by on 2023-04-24 11:36 AM
 */
@LiteflowComponent("condition")
public class ConditionCmp extends NodeIfComponent {

    @Override
    public boolean processIf() {
        return false;
    }
}