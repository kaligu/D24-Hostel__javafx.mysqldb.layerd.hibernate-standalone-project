/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/13/2023
  @ Time         : 12:08 PM
*/
package lk.d24.hostelsystem.service.custom.impl;

import lk.d24.hostelsystem.dao.DAOFactory;
import lk.d24.hostelsystem.dao.DAOTypes;
import lk.d24.hostelsystem.dao.custom.LoginDetailDAO;
import lk.d24.hostelsystem.dao.custom.RoomDAO;
import lk.d24.hostelsystem.dto.LoginDetailDTO;
import lk.d24.hostelsystem.dto.RoomDTO;
import lk.d24.hostelsystem.entity.LoginDetail;
import lk.d24.hostelsystem.service.custom.LoginDetailService;
import lk.d24.hostelsystem.service.util.Convertor;
import lk.d24.hostelsystem.util.HbFactoryConfiguration;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoginDetailServiceImpl implements LoginDetailService {
    private final LoginDetailDAO loginDetailDAO;
    private final Convertor convertor;
    private Session session;
    private Transaction transaction;

    public LoginDetailServiceImpl() {
        this.loginDetailDAO = DAOFactory.getInstance().getDAO(DAOTypes.LOGINDETAIL);
        this.convertor = new Convertor();
    }

    @Override
    public LoginDetailDTO findByPk(String pk) {
        LoginDetailDTO loginDetailDTO = null;
        session=null;
        transaction=null;
        session= HbFactoryConfiguration.getInstance().getSession();
        transaction=session.beginTransaction();

        try{
            loginDetailDTO = convertor.fromLoginDetail(loginDetailDAO.findByPk(session,pk));
            return loginDetailDTO;
        }catch (HibernateException e){
            if(session!=null) {
                transaction.rollback();
            }
            return  loginDetailDTO;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean update(LoginDetailDTO loginDetailDTO) {
        session=null;
        transaction=null;
        session= HbFactoryConfiguration.getInstance().getSession();
        transaction=session.beginTransaction();
        try{
            loginDetailDAO.update(session , convertor.toLoginDetail(loginDetailDTO));
            transaction.commit();
            return true;
        }catch (HibernateException e){
            if(session!=null) {
                transaction.rollback();
            }
            return false;
        }finally {
            session.close();
        }
    }
}
