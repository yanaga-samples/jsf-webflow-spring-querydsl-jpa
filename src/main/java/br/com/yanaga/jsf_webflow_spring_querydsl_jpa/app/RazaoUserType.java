package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app;

import br.com.insula.opes.hibernate.usertype.ImmutableUserType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;

public class RazaoUserType extends ImmutableUserType{

    @Override
    public int[] sqlTypes(){
        return new int[]{Types.VARCHAR};
    }

    @Override
    public Class returnedClass(){
        return Razao.class;
    }

    @Override
    public Object nullSafeGet(ResultSet rs,
                              String[] strings,
                              SessionImplementor si,
                              Object o) throws HibernateException, SQLException{
        String value = rs.getString(strings[0]);
        if(value != null)
            return Razao.newInstance(value);
        else
            return null;
    }

    @Override
    public void nullSafeSet(PreparedStatement ps,
                            Object o,
                            int i,
                            SessionImplementor si) throws HibernateException, SQLException{
        Razao razao = (Razao) o;
        if(razao != null)
            ps.setString(i, razao.toString());
        else
            ps.setNull(i, Types.VARCHAR);
    }
}
