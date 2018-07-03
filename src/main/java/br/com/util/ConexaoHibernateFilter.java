package br.com.util;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.servlet.*;
import org.hibernate.SessionFactory;
/**
 *
 * @author root
 */
public class ConexaoHibernateFilter implements Filter{
    private SessionFactory sf;
    @Override
    public void init(FilterConfig config) throws ServletException {
        try {
			this.sf = HibernateUtil.getSessionFactory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    @Override
    public void doFilter(ServletRequest servletRequest,
            ServletResponse servletResponse, 
            FilterChain chain) throws ServletException{
            try{
                this.sf.getCurrentSession().beginTransaction();
                chain.doFilter(servletRequest, servletResponse);
                this.sf.getCurrentSession().getTransaction().commit();
                this.sf.getCurrentSession().close();
            } catch (Throwable ex){
                try{
                    if(this.sf.getCurrentSession().getTransaction().isActive()){
                       this.sf.getCurrentSession().getTransaction().rollback();
                    }
                } catch (Throwable t){
                    t.printStackTrace();
                }
                throw new ServletException(ex);
            }
    }
    @Override
    public void destroy(){}
    public SessionFactory getSf() {
        return sf;
    }
    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }
}
