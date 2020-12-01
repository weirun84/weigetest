package repository.service.impl;

import com.halecms.infrastructure.sql.mysql.MybatisUtil;
import com.halecms.infrastructure.sql.mysql.dao.CtmonFeedbackDao;
import org.springframework.stereotype.Component;
import repository.service.IFeedbackService;

@Component("FeedbackService")
public class FeedbackService implements IFeedbackService {
    @Override
    public int GetFeedbackCount()
    {
        CtmonFeedbackDao FeedbackDao= (CtmonFeedbackDao) MybatisUtil.getMapper(CtmonFeedbackDao.class);
        Integer Feedbackcount=FeedbackDao.GetFeedBackCount();
        return  Feedbackcount;
    }
}
