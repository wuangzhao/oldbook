package org.fd.service.impl;

import org.fd.dao.BookDao;
import org.fd.dao.SellDao;
import org.fd.dto.SellExecution;
import org.fd.entity.SellEntity;
import org.fd.enums.SellStateEnum;
import org.fd.exception.FailureException;
import org.fd.exception.InnerException;
import org.fd.service.SellService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellServiceImpl implements SellService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SellDao sellDao;

    @Autowired
    private BookDao bookDao;

    @Override
    public SellEntity getById(int sellId) {
        return sellDao.queryById(sellId);
    }

    @Override
    public List<SellEntity> getByUserId(int userId) {
        return sellDao.queryByUserId(userId);
    }

    @Override
    public int insertSell(SellEntity sellEntity) {
        return sellDao.insertSell(sellEntity);
    }


    @Override
    public SellExecution addSell(SellEntity sellEntity) {
        try {
            if (bookDao.queryById(sellEntity.getBookId()) == null) {
                throw new FailureException("no such book");
            } else {
                int getSellId = sellDao.insertSell(sellEntity);
                return new SellExecution(sellEntity.getBookId(), SellStateEnum.SUCCESS, sellDao.queryById(getSellId));
            }
        } catch (FailureException e1) {
            throw e1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new InnerException("sell inner error" + e.getMessage());
        }
    }

}
