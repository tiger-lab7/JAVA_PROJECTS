import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DAOHibernate {

    public List<TaskH> getAllTasks() {
        @SuppressWarnings("unchecked")
        List<TaskH> taskList = (List<TaskH>) HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("SELECT * FROM works")
                .list();

       /* int id = 0;
        TaskH taskHObj = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .get(TaskH.class, "work");
        ArrayList<TaskH> taskList = new ArrayList<>();
        taskList.add(taskHObj);*/
        return taskList;
    }

    public void executeSql(String sql) {
        HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery(sql);
    }

    public void closeConnection() {
    }


}

class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(TaskH.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySetting("settings", configuration);
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return sessionFactory;
    }

}


