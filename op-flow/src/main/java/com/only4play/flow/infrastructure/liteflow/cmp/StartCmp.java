package com.only4play.flow.infrastructure.liteflow.cmp;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;

/**
 * @author tsy
 * Created by on 2023-04-24 11:36 AM
 */
@LiteflowComponent("start")
public class StartCmp extends NodeComponent {

    @Override
    public void process() throws Exception {
        System.out.println(this.getTag());
    }
}