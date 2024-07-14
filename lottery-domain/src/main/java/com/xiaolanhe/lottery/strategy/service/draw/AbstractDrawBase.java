package com.xiaolanhe.lottery.strategy.service.draw;

import cn.hutool.core.collection.CollectionUtil;
import com.xiaolanhe.lottery.common.Constants;
import com.xiaolanhe.lottery.infrastructure.po.Award;
import com.xiaolanhe.lottery.infrastructure.po.Strategy;
import com.xiaolanhe.lottery.infrastructure.po.StrategyDetail;
import com.xiaolanhe.lottery.strategy.model.aggregates.StrategyRich;
import com.xiaolanhe.lottery.strategy.model.request.DrawRequest;
import com.xiaolanhe.lottery.strategy.model.response.DrawResponse;
import com.xiaolanhe.lottery.strategy.model.vo.AwardInfo;
import com.xiaolanhe.lottery.strategy.model.vo.AwardRateInfo;
import com.xiaolanhe.lottery.strategy.service.algorithm.IDrawAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/** 抽奖模板类： 定义抽奖过程
 *@author: xiaolanhe
 *@createDate: 2024/7/14 14:56
 */
public abstract class AbstractDrawBase extends DrawStrategyHelper implements IDrawExec{
    private Logger logger = LoggerFactory.getLogger(AbstractDrawBase.class);

    @Override
    public DrawResponse doDrawExec(DrawRequest request) {
        // 1. 获取抽奖策略等信息
        StrategyRich strategyRich = queryStrategyRich(request.getStrategyId());
        Strategy strategy = strategyRich.getStrategy();

        // 2、校验抽奖策略并初始化奖品中奖概率到内存
        checkAndInitRateData(request.getStrategyId(), strategy.getStrategyMode(), strategyRich.getStrategyDetailList());

        // 3、获取需要排除的奖品id
        List<String> excludeAwardIds = queryExcludeAwardIds(request.getStrategyId());

        // 4、执行抽奖算法
        String awards = drawAlgorithm(request.getStrategyId(), drawAlgorithmMap.get(strategy.getStrategyMode()), excludeAwardIds);
        logger.info("抽奖完毕， awards:{}", awards);

        return buildDrawResult(request.getUid(), request.getStrategyId(), awards);
    }

    /**
     * desciption 获取需要排除的抽奖id，用于奖品库为空、风控策略、临时调整等，这类数据由具体的业务场景决定
      * @param strategyId
     * @return 排除的奖品ID集合
     * @Date 2024/7/14 15:01
    */
    protected abstract List<String> queryExcludeAwardIds(Long strategyId);

    /**
     * desciption 抽奖算法
     * @param strategyId 策略ID
     * @param drawAlgorithm  抽奖算法模型
     * @param excludeAwardIds 排除的奖品ID集合
     * @return 所中奖品id
     * @Date 2024/7/14 15:05
    */
    protected abstract String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludeAwardIds);

    /**
     * 校验抽奖策略是否已经初始化到内存
     *
     * @param strategyId         抽奖策略ID
     * @param strategyMode       抽奖策略模式
     * @param strategyDetailList 抽奖策略详情
     */
    protected void checkAndInitRateData(Long strategyId, Integer strategyMode, List<StrategyDetail> strategyDetailList){

        // 非单项概率，每个奖品的概率都会受其他奖品种类库存的影响，所以每必要缓存
        if(!Constants.StrategyModeEnum.SINGLE.getCode().equals(strategyMode)){
            return;
        }

        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategyMode);

        // 检测是否已经进行过初始化
        if(drawAlgorithm.isExistRateTuple(strategyId)){
            return;
        }

        if(CollectionUtil.isNotEmpty(strategyDetailList)){
            List<AwardRateInfo> awardRateInfos = strategyDetailList.stream().map(n -> new AwardRateInfo(n.getAwardId(), n.getAwardRate()))
                    .collect(Collectors.toList());
            drawAlgorithm.initRateTuple(strategyId, awardRateInfos);
        }

    }

    /**
     * desciption 构建抽奖结果
     * @param uid 用户id
     * @param strategyId 策略id
     * @param awardId 奖品id
     * @return DrawResponse
     * @Date 2024/7/14 15:10
    */
    private DrawResponse buildDrawResult(String uid, Long strategyId, String awardId){
        if(!StringUtils.hasText(awardId)){
            logger.info("执行策略抽奖完成【未中奖】，用户：{} 策略ID：{}", uid, strategyId);
            return new DrawResponse(uid, strategyId, Constants.DrawResultEnum.NO_PRIZE.getCode());
        }
        Award award = queryAwardInfo(awardId);
        AwardInfo awardInfo = new AwardInfo(award.getAwardId(), award.getAwardType(), award.getAwardName(), award.getAwardContent());
        logger.info("执行策略抽奖完成【中奖】，用户：{} 策略ID：{} 奖品ID：{} 奖品名称：{}", uid, strategyId, awardId, award.getAwardName());
        return new DrawResponse(uid, strategyId, Constants.DrawResultEnum.SUCCESS.getCode(), awardInfo);
    }
}
