package com.xiaolanhe.lottery.strategy.service.draw.impl;

import com.xiaolanhe.lottery.infrastructure.po.Award;
import com.xiaolanhe.lottery.infrastructure.po.Strategy;
import com.xiaolanhe.lottery.infrastructure.po.StrategyDetail;
import com.xiaolanhe.lottery.strategy.model.aggregates.StrategyRich;
import com.xiaolanhe.lottery.strategy.model.request.DrawRequest;
import com.xiaolanhe.lottery.strategy.model.response.DrawResponse;
import com.xiaolanhe.lottery.strategy.repository.IStrategyRepository;
import com.xiaolanhe.lottery.strategy.service.algorithm.IDrawAlgorithm;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DrawExecImplTest {

    @Mock
    private IStrategyRepository strategyRepository;

    @Mock
    private IDrawAlgorithm drawAlgorithm;

    @InjectMocks
    private DrawExecImpl drawExec;

    private Map<Integer, IDrawAlgorithm> drawAlgorithmMap = new HashMap<>();

    @Before
    public void setUp() {
        drawAlgorithmMap.put(1, drawAlgorithm);
        drawExec.setDrawAlgorithmMap(drawAlgorithmMap);
        
        Strategy strategy = new Strategy();
        strategy.setStrategyMode(1); // 单项概率
        StrategyRich strategyRich = new StrategyRich();
        strategyRich.setStrategy(strategy);
        strategyRich.setStrategyDetailList(Arrays.asList(new StrategyDetail(), new StrategyDetail()));

        when(strategyRepository.queryStrategyRich(anyLong())).thenReturn(strategyRich);
        when(drawAlgorithm.randomDraw(anyLong(), anyList())).thenReturn("awardId");
        
        Award award = new Award();
        award.setAwardId("awardId");
        award.setAwardName("Test Award");
        when(strategyRepository.queryAwardInfo("awardId")).thenReturn(award);
    }

    @Test
    public void testDoDrawExec() {
        DrawRequest request = new DrawRequest();
        request.setUid("testUser");
        request.setStrategyId(1L);

        DrawResponse response = drawExec.doDrawExec(request);
        assertEquals("testUser", response.getUid());
        assertEquals(Long.valueOf(1L), response.getStrategyId());
        assertEquals("awardId", response.getAwardId());
        assertEquals("Test Award", response.getAwardName());
    }

}
