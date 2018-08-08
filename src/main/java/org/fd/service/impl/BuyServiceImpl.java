package org.fd.service.impl;

import org.fd.dao.BuyDao;
import org.fd.dao.SellDao;
import org.fd.dto.BuyExecution;
import org.fd.entity.BuyEntity;
import org.fd.entity.SellEntity;
import org.fd.entity.UserEntity;
import org.fd.enums.BuyStateEnum;
import org.fd.exception.FailureException;
import org.fd.exception.IllegalException;
import org.fd.exception.InnerException;
import org.fd.service.BuyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BuyServiceImpl implements BuyService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BuyDao buyDao;

    @Autowired
    private SellDao sellDao;

    @Override
    public List<BuyEntity> getByUserId(int userId) {
        return buyDao.queryByUserId(userId);
    }

    @Override
    @Transactional
    public BuyExecution addBuy(int userId, int sellId) {
        try {
            SellEntity sell = sellDao.queryById(sellId);
            if (sell == null) {
                throw new FailureException("not such sell");
            } else if (sell.getSellStatus() == 1) {
                throw new FailureException("has sold");
            } else if (sellDao.queryById(sellId).getUserId() == userId) {
                throw new IllegalException("can't buy yourself sell");
            } else {
                BuyEntity buyEntity = new BuyEntity();
                buyEntity.setSellId(sellId);
                buyEntity.setUserId(userId);
                int getBuyId = buyDao.insert(buyEntity);
                return new BuyExecution(sellId, BuyStateEnum.SUCCESS, buyDao.queryByBuyId(getBuyId));
            }
        } catch (FailureException e1) {
            throw e1;
        } catch (IllegalException e2) {
            throw e2;
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new InnerException("buy inner error" + e.getMessage());
        }
    }

    @Override
    public boolean userDelete(BuyEntity buyEntity) {
        if (buyDao.userDelete(buyEntity) == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public BuyEntity getByBuyId(int buyId) {
        return buyDao.queryByBuyId(buyId);
    }
}
